package hellspawn287.crm_account_deduplication_logic.repository;

import hellspawn287.crm_account_deduplication_logic.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findByCompanyName(String name);

    Optional<Company> findByNip(String nip);


}