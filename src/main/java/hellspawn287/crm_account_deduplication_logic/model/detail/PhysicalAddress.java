package hellspawn287.crm_account_deduplication_logic.model.detail;

import hellspawn287.crm_account_deduplication_logic.model.OldAccount;
import hellspawn287.crm_account_deduplication_logic.model.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "physical")
public class PhysicalAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_physical")
    private Integer id;

    @NotNull
    @Column(name = "physical")
    private byte[] physicalAddress;

    @NotNull
    @ManyToMany(mappedBy = "physicals1")
    private List<Person> people;

    @NotNull
    @ManyToMany(mappedBy = "physicals2")
    private List<OldAccount> accounts;

    public PhysicalAddress() {
    }

    public PhysicalAddress(@NotNull byte[] physicalAddress,
                           @NotNull List<Person> people,
                           @NotNull List<OldAccount> accounts) {
        this.physicalAddress = physicalAddress;
        this.people = people;
        this.accounts = accounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(byte[] physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<OldAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<OldAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhysicalAddress)) return false;
        PhysicalAddress that = (PhysicalAddress) o;
        return Arrays.equals(physicalAddress, that.physicalAddress);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(physicalAddress);
    }

    @Override
    public String toString() {
        return "PhysicalAddress{" +
                "id=" + id +
                ", physicalAddress=" + Arrays.toString(physicalAddress) +
                '}';
    }
}
