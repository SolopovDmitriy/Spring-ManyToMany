package com.example.clients_service.service_db;


import com.example.clients_service.models.Account;
import com.example.clients_service.models.Client;
import com.example.clients_service.services.data.service_db.AccountServiceDb;
import com.example.clients_service.services.data.service_db.ClientServiceDb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
public class AccountServiceDbTest {  // //@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
    @Autowired
    AccountServiceDb accountServiceDb;


    // добавление аккаунтов  // получение аккаунта по id
    @Test
    void createAndFindAccount() throws Exception {
        // Arrange
        Account dollarFamily = new Account(1L, 10000, null);
        accountServiceDb.save(dollarFamily);

        // Act
        Account actual = accountServiceDb.findById(1L);

        // Assert
        Account expected = dollarFamily;
        Assertions.assertEquals(expected, actual);
    }

    // добавление аккаунтов  // удаление аккаунтов  // получение аккаунта по id
    @Test
    void createThenDeleteAndThenFindAccount() throws Exception {
        // Arrange
        Account dollarFamily = new Account(1L, 10000, null);
        accountServiceDb.save(dollarFamily);

        // Act
        accountServiceDb.deleteById(1L);

        // Assert
        Account actual = accountServiceDb.findById(1L);
        Assertions.assertNull(actual);
    }




    // получения всех аккаунтов
    @Test
    void createManyAndFindAllAccounts() throws Exception {
        // Arrange
        Account account1 = new Account(1L, 10000, null);
        accountServiceDb.save(account1);
        Account account2 = new Account(2L, 20000, null);
        accountServiceDb.save(account2);

        // Act
        List<Account> actual = accountServiceDb.findAll();

        // Assert
        List<Account>  expected = Arrays.asList(account1, account2);
        Assertions.assertEquals(expected, actual);
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
