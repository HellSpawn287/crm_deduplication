package hellspawn287.crm_account_deduplication_logic.model;

import hellspawn287.crm_account_deduplication_logic.model.validators.Validators;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_company")
    private UUID id;

    @NIP
    private String nip;

    @NotNull(message = "Company name is missing.")
    private String companyName;

    @NotNull
    @OneToMany(mappedBy = "company")
    private Set<Person> personSet;

    public Company() {
    }

    public Company(@NIP String nip, @NotNull(message = "Company name is missing.") String companyName, @NotNull Set<Person> personSet) {
        if (Validators.isNIPValid(nip)) {
            this.nip = nip;
        } else {
            this.nip = "";
        }
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
    public int hashCode() {
        return Objects.hash(companyName, nip, personSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return id.equals(company.id) &&
                nip.equals(company.nip) &&
                companyName.equals(company.companyName) &&
                personSet.equals(company.personSet);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}