package hellspawn287.crm_account_deduplication_logic.model;

import hellspawn287.crm_account_deduplication_logic.model.detail.DetailAddress;
import hellspawn287.crm_account_deduplication_logic.model.detail.PhysicalAddress;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "accounts")
public class OldAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_account")
    private UUID id;

    @NIP
    @Column(name = "nip_account", nullable = true, unique = true)
    private String nip;

    private String companyName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

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
    @OneToMany(mappedBy = "account")
    private Set<DetailAddress> detailAddresses;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "account_physicals",
            joinColumns = {@JoinColumn (name = "account_id", referencedColumnName = "id_account")},
            inverseJoinColumns = {@JoinColumn(name = "physical_id", referencedColumnName = "id_physical")}
    )
    private List<PhysicalAddress> physicals2;

    @OneToMany(mappedBy = "account")
    private Map<LocalDateTime, ArchiveEmail> emailsHistory;

    public OldAccount() {
    }

    public OldAccount(@NIP String nip, String companyName, @Email String email,
                      @NotNull(message = "First name is empty") String firstName,
                      @NotNull(message = "Last name is empty") String lastName,
                      @NotNull(message = "Phone number can not be empty.") String phoneNumber1,
                      String phoneNumber2, @NotNull(message = "Login is empty.") String login,
                      @NotNull(message = "Address details are missing.") Set<DetailAddress> detailAddresses, List<PhysicalAddress> physicals2) {
        this.nip = nip;
        this.companyName = companyName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.login = login;
        this.detailAddresses = detailAddresses;
        this.physicals2 = physicals2;
        this.emailsHistory = new HashMap<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    public List<PhysicalAddress> getPhysicals2() {
        return physicals2;
    }

    public void setPhysicals2(List<PhysicalAddress> physical) {
        this.physicals2 = physical;
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
        if (!(o instanceof OldAccount)) return false;
        OldAccount that = (OldAccount) o;
        return email.equals(that.email) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName);
    }

    @Override
    public String toString() {
        return "OldAccount{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", login='" + login + '\'' +
                ", detailAddresses=" + detailAddresses +
                ", physical=" + physicals2 +
                '}';
    }
}
