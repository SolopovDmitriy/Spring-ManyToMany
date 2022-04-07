package com.example.clients_service.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Setter
@NoArgsConstructor
@AllArgsConstructor

//
@Entity
@Table(name = "clients")
public class Client {

    public Long getId() {
        return this.id;
    }

    public String getSurname() {
        if(this.surname == null){
            return "no value";
        }
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String getEmail() {
        return this.email;
    }

    public Gender getGender() {
        return this.gender;
    }

    public List<Phone> getPhones() {
        return phones;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(name, client.name) &&
                Objects.equals(patronymic, client.patronymic) &&
                Objects.equals(email, client.email) &&
                Objects.equals(birthDate, client.birthDate) &&
                gender == client.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, email, birthDate, gender);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }



    public enum Gender{
        MALE, FEMALE, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 30)
    private String surname;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String patronymic;
    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = true, length = 50)
    private String email;

    @Column
    private Gender gender;

    public Set<Account> getAccounts() {
        return accounts;
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Phone> phones;


    @ManyToMany
    @JoinTable(name = "clients_accounts",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id")
    )
    private Set<Account> accounts;
}
