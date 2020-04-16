package hellspawn287.crm_account_deduplication_logic.model;

import hellspawn287.crm_account_deduplication_logic.model.detail.DetailAddress;
import hellspawn287.crm_account_deduplication_logic.model.detail.PhysicalAddress;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
    private static final long serialVersionUID = 37L;

    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private UUID id;
    @NotNull(message = "First name is empty")
    private String firstName;
    @NotNull(message = "Last name is empty")
    private String lastName;
    @NotNull(message = "Phone number can not be empty.")
    @Column(name = "phone_1")
    private String phoneNumber1;
    @Column(name = "phone_2")
    private String phoneNumber2;

    @NotNull(message = "Login is empty.")
    private String login;

    @NotNull(message = "Address details are missing.")
    @OneToMany(mappedBy = "person")
    @Valid
    private Set<DetailAddress> detailAddresses;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "person_physicals",
            joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id_person")},
            inverseJoinColumns = {@JoinColumn(name = "physical_id", referencedColumnName = "id_physical")}
    )
    private List<PhysicalAddress> physicals1;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @NotNull
    @OneToMany(mappedBy = "person")
    private Map<LocalDateTime, ArchiveEmail> emailsHistory;


    public Person() {
    }

    public Person(UUID id, String email, String firstName, String lastName, String phoneNumber1, String phoneNumber2, String login, DetailAddress detailAddress, List<PhysicalAddress> physicals1) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.login = login;
        this.physicals1 = physicals1;
        createDetailAddresses(detailAddress);
        this.emailsHistory = new HashMap<>();
    }

    private void createDetailAddresses(DetailAddress detailAddress) {
        this.detailAddresses = new HashSet<>();
        this.detailAddresses.add(detailAddress);
    }

    public void addDetailAddress(DetailAddress detailAddress) {
        if (this.detailAddresses != null) {
            this.detailAddresses.add(detailAddress);
        }
    }

    public boolean isActual(String newEmail) {
        return newEmail.equals(this.email);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isActual(email)) {
            String archiving = this.email;
            ArchiveEmail old = new ArchiveEmail(archiving);
            emailsHistory.put(LocalDateTime.now(), old);
        }
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<DetailAddress> getDetailAddresses() {
        return detailAddresses;
    }

    public void setDetailAddresses(Set<DetailAddress> detailAddresses) {
        this.detailAddresses = detailAddresses;
    }

    public List<PhysicalAddress> getPhysicals1() {
        return physicals1;
    }

    public void setPhysicals1(List<PhysicalAddress> physical) {
        this.physicals1 = physical;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Map<LocalDateTime, ArchiveEmail> getEmailsHistory() {
        return emailsHistory;
    }

    public void setEmailsHistory(Map<LocalDateTime, ArchiveEmail> emailsHistory) {
        this.emailsHistory = emailsHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return email.equals(person.email) &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                phoneNumber1.equals(person.phoneNumber1) &&
                Objects.equals(phoneNumber2, person.phoneNumber2) &&
                login.equals(person.login) &&
                detailAddresses.equals(person.detailAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, phoneNumber1, phoneNumber2, login, detailAddresses);
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", login='" + login + '\'' +
                ", detailAddresses=" + detailAddresses +
                ", physical=" + physicals1 +
                '}';
    }
}