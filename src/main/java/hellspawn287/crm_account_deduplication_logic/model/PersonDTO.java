package hellspawn287.crm_account_deduplication_logic.model;

import hellspawn287.crm_account_deduplication_logic.model.detail.DetailAddress;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class PersonDTO {

    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber1;
    private String phoneNumber2;
    private String login;
    private Set<DetailAddress> detailAddresses;
    private Company company;

    public PersonDTO() {
    }

    public PersonDTO(UUID id, String email,
                     String firstName, String lastName,
                     String phoneNumber1, String phoneNumber2,
                     String login, Set<DetailAddress> detailAddresses,
                     Company company) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.login = login;
        this.detailAddresses = detailAddresses;
        this.company = company;
    }

    public PersonDTO(UUID id, String email, String firstName,
                     String lastName, String phoneNumber1,
                     String phoneNumber2, String login,
                     Set<DetailAddress> detailAddresses) {
        this.id = id;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, phoneNumber1, phoneNumber2, login, detailAddresses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO)) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return id.equals(personDTO.id) &&
                email.equals(personDTO.email) &&
                firstName.equals(personDTO.firstName) &&
                lastName.equals(personDTO.lastName) &&
                phoneNumber1.equals(personDTO.phoneNumber1) &&
                Objects.equals(phoneNumber2, personDTO.phoneNumber2) &&
                login.equals(personDTO.login) &&
                detailAddresses.equals(personDTO.detailAddresses);
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", login='" + login + '\'' +
                ", detailAddresses=" + detailAddresses +
                ", company=" + company +
                '}';
    }
}
