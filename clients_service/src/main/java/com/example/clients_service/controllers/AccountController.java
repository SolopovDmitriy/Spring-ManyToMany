package com.example.clients_service.controllers;

import com.example.clients_service.models.Account;
import com.example.clients_service.models.Client;
import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.AccountService;
import com.example.clients_service.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public String account(Model model){
        List<Account> accounts = accountService.findAll();
        accounts.sort(Comparator.comparingLong(Account::getId));
        accounts.sort(Comparator.comparingLong(Account::getId).reversed());
        accounts.sort(Comparator.comparingLong(Account::getId));
        model.addAttribute("accounts", accounts);
        return "account";
    }


    @PostMapping("add_account")
    public String addPhone(Model model, String amount){
        Account account = new Account(0L, Integer.parseInt(amount), null);
        accountService.save(account);
        return "redirect:/accounts";
    }

}
