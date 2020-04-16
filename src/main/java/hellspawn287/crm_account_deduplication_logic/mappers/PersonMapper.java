package hellspawn287.crm_account_deduplication_logic.mappers;

import hellspawn287.crm_account_deduplication_logic.model.Person;
import hellspawn287.crm_account_deduplication_logic.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toPersonDTO(Person entity);

    Person toPersonEntity(PersonDTO dto);
}
