package hellspawn287.crm_account_deduplication_logic.service;

import hellspawn287.crm_account_deduplication_logic.exception.*;
import hellspawn287.crm_account_deduplication_logic.mappers.CompanyMapper;
import hellspawn287.crm_account_deduplication_logic.model.Company;
import hellspawn287.crm_account_deduplication_logic.model.CompanyDTO;
import hellspawn287.crm_account_deduplication_logic.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    CompanyMapper mapper = CompanyMapper.INSTANCE;

    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public CompanyDTO save(CompanyDTO companyDTO) {
        Optional<Company> foundByNIP = repository.findByNip(companyDTO.getNip());
        foundByNIP.ifPresent(x -> {
            throw new DuplicateNipException();

        });
        return mapAndSave(companyDTO);
    }

    public CompanyDTO update(CompanyDTO companyDTO) {
        Optional<Company> foundByNIP = repository.findByNip(companyDTO.getNip());
        foundByNIP.ifPresent(x -> {
            if (!x.getNip().equals(companyDTO.getNip()))
                throw new NipNotFoundException();

        });
        return mapAndSave(companyDTO);
    }

    private CompanyDTO mapAndSave(CompanyDTO companyDTO) {
        Company saved = repository.save(mapper.toCompanyEntity(companyDTO));
        return mapper.toCompanyDTO(saved);
    }

    public boolean checkIfFoundByNip(String nip){
        return repository.findByNip(nip).isPresent();
    }

    public Optional<CompanyDTO> findByNip(String nip){
        return repository.findByNip(nip).map(mapper::toCompanyDTO);
    }
}
