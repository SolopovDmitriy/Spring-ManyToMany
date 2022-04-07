package com.example.clients_service.models;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private Integer amount;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "accounts")
    private Set<Client> clients;

    public Set<Client> getClients() {
        return clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(amount, account.amount) && Objects.equals(id, account.id);
        // return amount == account.amount &&  Objects.equals(id, account.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }





    
}
