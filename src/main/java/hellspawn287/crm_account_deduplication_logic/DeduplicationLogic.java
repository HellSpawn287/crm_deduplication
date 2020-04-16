package hellspawn287.crm_account_deduplication_logic;

import hellspawn287.crm_account_deduplication_logic.mappers.OldAccountToCompanyMapper;
import hellspawn287.crm_account_deduplication_logic.mappers.PersonMapper;
import hellspawn287.crm_account_deduplication_logic.model.CompanyDTO;
import hellspawn287.crm_account_deduplication_logic.model.OldAccountDTO;
import hellspawn287.crm_account_deduplication_logic.model.Person;
import hellspawn287.crm_account_deduplication_logic.service.CompanyService;
import hellspawn287.crm_account_deduplication_logic.service.OldAccountService;
import hellspawn287.crm_account_deduplication_logic.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Controller
public class DeduplicationLogic {

    private List<OldAccountDTO> withNIP;
    private List<OldAccountDTO> withOutNIP;
    private PersonService personService;
    private CompanyService companyService;
    private OldAccountService oldAccountService;
    private OldAccountToCompanyMapper oldAccountToCompanyMapper = new OldAccountToCompanyMapper();
    private PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public DeduplicationLogic(PersonService personService, CompanyService companyService, OldAccountService oldAccountService) {
        this.personService = personService;
        this.companyService = companyService;
        this.oldAccountService = oldAccountService;
    }

    public void deduplication() {
        withNIP = oldAccountService.findAllByNipNotNull();
        withOutNIP = oldAccountService.findAllByNipIsNull();

        for (OldAccountDTO account : withNIP) {
            if (companyService.checkIfFoundByNip(account.getNip())) {

                CompanyDTO accountAddedToCompanyPersonSet = companyService.findByNip(account.getNip()).get();
                accountAddedToCompanyPersonSet.setId(account.getId());
                accountAddedToCompanyPersonSet.setCompanyName(account.getCompanyName());
                Person person = personMapper.toPersonEntity(
                        oldAccountToCompanyMapper.mapToPersonDtoWithNullCompany(account)
                );
                Set<Person> personSet = accountAddedToCompanyPersonSet.getPersonSet();
                personSet.add(person);
                accountAddedToCompanyPersonSet.setPersonSet(personSet);

                companyService.update(accountAddedToCompanyPersonSet);
                oldAccountService.removeByLogin(account);
            } else {
                CompanyDTO toSave = oldAccountToCompanyMapper.mapToCompanyDTO(account);
                companyService.save(toSave);
                oldAccountService.removeByLogin(account);
            }
        }

        for (OldAccountDTO account : withOutNIP) {
            Person person = personMapper.toPersonEntity(
                    oldAccountToCompanyMapper.mapToPersonDtoWithNullCompany(account)
            );
            if (personService.checkIfFoundByLogin(account.getLogin())) {
                personService.update(personMapper.toPersonDTO(person));
                oldAccountService.removeByLogin(account);
            } else {
                personService.save(personMapper.toPersonDTO(person));
                oldAccountService.removeByLogin(account);
            }
        }
    }

}