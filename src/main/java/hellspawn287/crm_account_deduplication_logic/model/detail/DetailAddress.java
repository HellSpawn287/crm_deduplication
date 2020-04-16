package hellspawn287.crm_account_deduplication_logic.model.detail;

import hellspawn287.crm_account_deduplication_logic.model.OldAccount;
import hellspawn287.crm_account_deduplication_logic.model.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class DetailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private Integer id;

    @NotNull(message = "Postal address can not be empty")
    @Column(name = "address")
    private String address;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_account", nullable = false)
    private OldAccount account;

    public DetailAddress() {
    }

    public DetailAddress(@NotNull(message = "Postal address can not be empty") String address, @NotNull Person person, @NotNull OldAccount account) {
        this.address = address;
        this.person = person;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "DetailAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
