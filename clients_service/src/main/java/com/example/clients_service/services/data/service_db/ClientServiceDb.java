package com.example.clients_service.services.data.service_db;

import com.example.clients_service.models.Client;
import com.example.clients_service.repositories.ClientRepository;
import com.example.clients_service.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ClientServiceDb implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return clientRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }

    @Override
    public Client save(Client client){
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
        TypedQuery<Client> q = entityManager.createQuery("SELECT a FROM Client a LEFT JOIN FETCH a.phones", Client.class);
        List<Client> clients = q.getResultList();
//        entityManager.getTransaction().commit();
        entityManager.close();
        return clients;
    }


    @Override
    public Client findByEmail(String email) throws Exception {
        List<Client> clients = clientRepository.findAllByEmail(email);
        if (clients.isEmpty()){
            return null;
        }
        if(clients.size() > 1){
            throw new Exception("2 or more clients with this email");
        }
        return clients.get(0);
    }






}
