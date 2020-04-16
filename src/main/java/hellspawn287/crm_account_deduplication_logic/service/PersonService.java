package hellspawn287.crm_account_deduplication_logic.service;

import hellspawn287.crm_account_deduplication_logic.exception.DuplicateEmailException;
import hellspawn287.crm_account_deduplication_logic.exception.EmailNotFoundException;
import hellspawn287.crm_account_deduplication_logic.mappers.PersonMapper;
import hellspawn287.crm_account_deduplication_logic.model.Person;
import hellspawn287.crm_account_deduplication_logic.model.PersonDTO;
import hellspawn287.crm_account_deduplication_logic.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    PersonMapper mapper = PersonMapper.INSTANCE;

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonDTO save(PersonDTO personDTO) {
        Optional<Person> foundByEmail = repository.findByEmail(personDTO.getEmail());
        foundByEmail.ifPresent(x -> {
            throw new DuplicateEmailException();

        });
        return mapAndSave(personDTO);
    }

    public PersonDTO update(PersonDTO personDTO) {
        Optional<Person> foundByEmail = repository.findByEmail(personDTO.getEmail());
        foundByEmail.ifPresent(x -> {
            if (!x.getEmail().equals(personDTO.getEmail()))
                throw new EmailNotFoundException();

        });
        return mapAndSave(personDTO);
    }

    public Optional<PersonDTO> findByLogin(String login) {
        return repository.findByLogin(login).map(mapper::toPersonDTO);
    }

    public Optional<PersonDTO> findById(UUID id) {
        return repository.findById(id).map(mapper::toPersonDTO);
    }

    public List<PersonDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toPersonDTO)
                .collect(Collectors.toList());
    }

    private PersonDTO mapAndSave(PersonDTO personDTO) {
        Person saved = repository.save(mapper.toPersonEntity(personDTO));
        return mapper.toPersonDTO(saved);
    }

    public boolean checkIfFoundByLogin(String login) {
        return repository.findByLogin(login).isPresent();
    }

    public boolean checkIfFoundByEmail(String email) {
        return repository.findByEmail(email).isPresent();
    }
}