package com.example.clients_service.service_db;


import com.example.clients_service.models.Client;
import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.service_db.ClientServiceDb;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ClientServiceDbTest {
    @Autowired
    ClientServiceDb clientServiceDb;




    @Test
    void findClientByEmailWhenExist() throws Exception {
        // Arrange
        Client c1 = new Client(1L, "S2", "N2", "P2", LocalDate.now(), "admin@domain.com", Client.Gender.FEMALE, null, null);
        clientServiceDb.save(c1);
        Client c2 = new Client(2L, "S2", "N2", "P2", LocalDate.now(), "hello@domain.com", Client.Gender.FEMALE, null, null);
        clientServiceDb.save(c2);

        // Act
        Client actual = clientServiceDb.findByEmail("admin@domain.com");

        // Assert
        Client expected = c1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findClientByEmailWhenNotExist() throws Exception {
        // Arrange
        Client c1 = new Client(1L, "S2", "N2", "P2", LocalDate.now(), "admin@domain.com", Client.Gender.FEMALE, null, null);
        clientServiceDb.save(c1);
        Client c2 = new Client(2L, "S2", "N2", "P2", LocalDate.now(), "hello@domain.com", Client.Gender.FEMALE, null, null);
        clientServiceDb.save(c2);

        // Act
        Client actual = clientServiceDb.findByEmail("Petrov@domain.com");

        // Assert
        Client expected = null;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void findClientByEmailWhenManyClientsWithThisEmail() throws Exception {
        // Arrange
        Client c1 = new Client(1L, "S2", "N2", "P2", LocalDate.now(), "admin@domain.com", Client.Gender.FEMALE, null, null);
        clientServiceDb.save(c1);
        Client c2 = new Client(2L, "S2", "N2", "P2", LocalDate.now(), "admin@domain.com", Client.Gender.FEMALE, null, null);
        clientServiceDb.save(c2);


        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> clientServiceDb.findByEmail("admin@domain.com"));

    }


//    @Test
//    void AddPhoneToClient() throws Exception {
//        // Arrange
//        Phone phone1 = new Phone(1L, "12345432", null);
//        Set<Phone> phones = new HashSet<>();
//        phones.add(phone1);
//
//        Client c1 = new Client(1L, "S2", "N2", "P2", LocalDate.now(),
//                "admin@domain.com", Client.Gender.FEMALE, phones);
//        clientServiceDb.save(c1);
//
//        // Assert
//        Client client = clientServiceDb.findByEmail("admin@domain.com");
//        Phone phone2 = client.getPhones().iterator().next();
//
//        Assertions.assertEquals(phone1, phone2);
//
//    }






}
