package hellspawn287.crm_account_deduplication_logic.repository;

import hellspawn287.crm_account_deduplication_logic.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByEmail(String email);

    Optional<Person> findByLogin(String login);
}