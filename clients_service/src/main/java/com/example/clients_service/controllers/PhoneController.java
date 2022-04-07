package com.example.clients_service.controllers;

import com.example.clients_service.models.Client;
import com.example.clients_service.models.Client.Gender;
import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Controller
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/phones")
    public String phone(Model model){
        List<Phone> phones = phoneService.findAll();
        phones.sort(Comparator.comparingLong(Phone::getId));
        phones.sort(Comparator.comparingLong(Phone::getId).reversed());
        phones.sort(Comparator.comparingLong(Phone::getId));
        model.addAttribute("phones", phones);
        return "phone";
    }


    @PostMapping("add_phone")
    public String addPhone(Model model, @RequestParam("phone")String phone){
        Phone phone1 = new Phone(0L, phone, null);
        phoneService.save(phone1);
        return "redirect:/phones";
    }
}
