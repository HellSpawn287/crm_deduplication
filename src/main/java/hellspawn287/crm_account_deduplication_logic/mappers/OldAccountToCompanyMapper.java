package hellspawn287.crm_account_deduplication_logic.mappers;

import hellspawn287.crm_account_deduplication_logic.model.CompanyDTO;
import hellspawn287.crm_account_deduplication_logic.model.OldAccountDTO;
import hellspawn287.crm_account_deduplication_logic.model.Person;
import hellspawn287.crm_account_deduplication_logic.model.PersonDTO;

import java.util.HashSet;
import java.util.Set;

public class OldAccountToCompanyMapper {
    PersonMapper personMapper = PersonMapper.INSTANCE;
    CompanyMapper companyMapper = CompanyMapper.INSTANCE;

    public CompanyDTO mapToCompanyDTO(OldAccountDTO account) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setNip(account.getNip());
        companyDTO.setCompanyName(account.getCompanyName());
        PersonDTO dto = mapToPersonDtoWithNullCompany(account);
        Set<Person> set = new HashSet();
        dto.setCompany(companyMapper.toCompanyEntity(companyDTO));
        set.add(personMapper.toPersonEntity(dto));
        companyDTO.setPersonSet(set);

        return companyDTO;
    }

    public PersonDTO mapToPersonDtoWithNullCompany(OldAccountDTO account) {
        return new PersonDTO(account.getId(),
                    account.getEmail(),
                    account.getFirstName(),
                    account.getLastName(),
                    account.getPhoneNumber1(),
                    account.getPhoneNumber2(),
                    account.getLogin(),
                    account.getDetailAddresses()
            );
    }
}
