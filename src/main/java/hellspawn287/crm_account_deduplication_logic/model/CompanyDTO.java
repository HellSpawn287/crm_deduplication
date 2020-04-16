package hellspawn287.crm_account_deduplication_logic.model;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class CompanyDTO {
    private UUID id;
    private String nip;
    private String companyName;
    private Set<Person> personSet;

    public CompanyDTO() {
    }

    public CompanyDTO(UUID id, String nip,
                      String companyName,
                      Set<Person> personSet) {
        this.id = id;
        this.nip = nip;
        this.companyName = companyName;
        this.personSet = personSet;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyDTO)) return false;
        CompanyDTO that = (CompanyDTO) o;
        return id.equals(that.id) &&
                nip.equals(that.nip) &&
                companyName.equals(that.companyName) &&
                personSet.equals(that.personSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, nip, personSet);
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", companyName='" + companyName + '\'' +
                ", personSet=" + personSet +
                '}';
    }
}
