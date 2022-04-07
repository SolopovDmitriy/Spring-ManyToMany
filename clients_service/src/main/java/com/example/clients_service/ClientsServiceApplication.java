package com.example.clients_service;

import com.example.clients_service.models.Account;
import com.example.clients_service.models.Client;
import com.example.clients_service.models.Phone;
import com.example.clients_service.repositories.ClientRepository;
import com.example.clients_service.repositories.PhoneRepository;
import com.example.clients_service.services.data.AccountService;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class ClientsServiceApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);
    }

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Qualifier("clientServiceDb")
    @Autowired
    //@ClientServiceQualifier
    private ClientService clientService;

//    @Qualifier("accountServiceDb")
    @Autowired
    //@ClientServiceQualifier
    private AccountService accountService;

    @Autowired
    private PhoneService phoneService;


    public void TestClientWithPhone(){


//        Client client1 = new Client(1L, "S2", "N2", "P2", LocalDate.now(),
//                "admin@domain.com", Client.Gender.FEMALE, null, null);
//        clientService.save(client1);
//        Phone phone1 = new Phone(1L, "12345432", client1);
//        phoneService.save(phone1);
//
//
//        // version 1
//        List<Client> clientList = clientService.findAll();
//        for (Client client : clientList) {
//            System.out.println("Name: " + client.getName() + " phone: " + client.getPhones().get(0).getNumber());
//        }


//        // version 2 FetchType.EAGER
//        // if  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)  in Client.java
//        System.out.println();
//        Client client = clientRepository.findAll().get(0);
//        System.out.println("Name: " + client.getName() + " phone: " + client.getPhones().get(0).getNumber());
    }



    @EventListener(ApplicationReadyEvent.class)
    public void applicationReade() throws Exception {

//
//        Client Dima = new Client(1L, "Solopov", "Dima", "Ivanovich", LocalDate.now(),
//                "admin@domain.com", Client.Gender.MALE, null, new HashSet<>());
//
//        Client Julia = new Client(2L, "Solopova", "Julia", "Mikhailivna", LocalDate.now(),
//                "admin@domain.com", Client.Gender.MALE, null, new HashSet<>());
//
//        Account grnD = new Account(1L, 10000, new HashSet<>());
//
//        Account grnJ = new Account(2L, 10000, new HashSet<>());
//
//        Account dollarFamily = new Account(3L, 10000, new HashSet<>());
//
//        accountService.save(grnD);
//        accountService.save(grnJ);
//        accountService.save(dollarFamily);
//
//        clientService.save(Dima);
//        clientService.save(Julia);
//
//        // Relations
//
//        Dima.getAccounts().add(grnD);
//        //grnD.getClients().add(Dima);
//
//        Julia.getAccounts().add(grnJ);
//        //grnJ.getClients().add(Julia);
//
//        Julia.getAccounts().add(dollarFamily);
//        //dollarFamily.getClients().add(Julia);
//
//        Dima.getAccounts().add(dollarFamily);
//        // dollarFamily.getClients().add(Dima);
//
//        clientService.save(Dima);
//        clientService.save(Julia);

// ==================================================



    }

}
