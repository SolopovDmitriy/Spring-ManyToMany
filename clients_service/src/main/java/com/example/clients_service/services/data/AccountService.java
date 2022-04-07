package com.example.clients_service.services.data;

import com.example.clients_service.models.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Account save(Account account);

    List<Account> findAll();

    Account findById(Long id);

    void deleteById(Long id);

    void deleteAll();
}
