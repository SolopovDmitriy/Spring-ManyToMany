package com.example.clients_service.repositories;

import com.example.clients_service.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    List<Client> findAllByEmail(String email);
}
