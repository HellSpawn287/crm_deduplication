package hellspawn287.crm_account_deduplication_logic.service;

import hellspawn287.crm_account_deduplication_logic.mappers.OldAccountMapper;
import hellspawn287.crm_account_deduplication_logic.model.OldAccountDTO;
import hellspawn287.crm_account_deduplication_logic.repository.OldAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OldAccountService {

    OldAccountMapper mapper = OldAccountMapper.INSTANCE;

    private OldAccountRepository repository;

    @Autowired
    public OldAccountService(OldAccountRepository repository) {
        this.repository = repository;
    }

    public Optional<OldAccountDTO> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toOldAccountDTO);
    }

    public Optional<OldAccountDTO> findByLogin(String login) {
        return repository.findByLogin(login).map(mapper::toOldAccountDTO);
    }

    public Optional<OldAccountDTO> findById(UUID id) {
        return repository.findById(id).map(mapper::toOldAccountDTO);
    }

    public List<OldAccountDTO> findAllByNipNotNull(){
        return repository.findAllByNipNotNull()
                .stream()
                .map(mapper::toOldAccountDTO)
                .collect(Collectors.toList());
    }

    public List<OldAccountDTO> findAllByNipIsNull(){
        return repository.findAllByNipIsNull()
                .stream()
                .map(mapper::toOldAccountDTO)
                .collect(Collectors.toList());
    }

    public List<OldAccountDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toOldAccountDTO)
                .collect(Collectors.toList());
    }

    public boolean removeByLogin(OldAccountDTO oldAccountDTO) {
        return repository.deleteByLogin(oldAccountDTO.getLogin());
    }
}
