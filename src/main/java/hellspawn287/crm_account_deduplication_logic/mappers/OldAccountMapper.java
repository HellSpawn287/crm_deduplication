package hellspawn287.crm_account_deduplication_logic.mappers;

import hellspawn287.crm_account_deduplication_logic.model.OldAccount;
import hellspawn287.crm_account_deduplication_logic.model.OldAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OldAccountMapper {

    OldAccountMapper INSTANCE = Mappers.getMapper(OldAccountMapper.class);

    OldAccountDTO toOldAccountDTO(OldAccount entity);

    OldAccount toOldAccountEntity(OldAccountDTO dto);
}
