package hellspawn287.crm_account_deduplication_logic.model;

import hellspawn287.crm_account_deduplication_logic.model.detail.DetailAddress;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class OldAccountDTO {
    private UUID id;
    private String nip;
    private String companyName;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber1;
    private String phoneNumber2;
    private String login;
    private Set<DetailAddress> detailAddresses;

    public OldAccountDTO() {
    }

    public OldAccountDTO(UUID id, String nip, String companyName, String email, String firstName, String lastName, String phoneNumber1, String phoneNumber2, String login, Set<DetailAddress> detailAddresses) {
        this.id = id;
        this.nip = nip;
        this.companyName = companyName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.login = login;
        this.detailAddresses = detailAddresses;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OldAccountDTO)) return false;
        OldAccountDTO that = (OldAccountDTO) o;
        return id.equals(that.id) &&
                email.equals(that.email) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                phoneNumber1.equals(that.phoneNumber1) &&
                login.equals(that.login) &&
                detailAddresses.equals(that.detailAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, login);
    }

    @Override
    public String toString() {
        return "OldAccountDTO{" +
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
                '}';
    }
}