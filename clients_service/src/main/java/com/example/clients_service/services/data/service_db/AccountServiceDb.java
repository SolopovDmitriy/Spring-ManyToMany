package com.example.clients_service.services.data.service_db;

import com.example.clients_service.models.Account;
import com.example.clients_service.models.Client;
import com.example.clients_service.repositories.AccountRepository;
import com.example.clients_service.services.data.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDb implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account){
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }


}
