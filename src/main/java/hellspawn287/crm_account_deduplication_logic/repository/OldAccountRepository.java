package hellspawn287.crm_account_deduplication_logic.repository;

import hellspawn287.crm_account_deduplication_logic.model.OldAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OldAccountRepository extends JpaRepository<OldAccount, UUID> {

    List<OldAccount> findAllByNipNotNull();

    List<OldAccount> findAllByNipIsNull();

    Optional<OldAccount> findByEmail(String email);

    Optional<OldAccount> findByLogin(String login);

    boolean deleteByLogin(String login);
}