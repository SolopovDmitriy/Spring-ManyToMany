package com.example.clients_service.services.data;

import com.example.clients_service.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    Client save(Client client);

    List<Client> findAll();

    Client findByEmail(String email) throws Exception;
}
