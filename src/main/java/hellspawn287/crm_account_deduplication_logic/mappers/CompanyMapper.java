package hellspawn287.crm_account_deduplication_logic.mappers;

import hellspawn287.crm_account_deduplication_logic.model.Company;
import hellspawn287.crm_account_deduplication_logic.model.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO toCompanyDTO(Company entity);

    Company toCompanyEntity(CompanyDTO dto);
}
