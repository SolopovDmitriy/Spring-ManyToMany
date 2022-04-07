package com.example.clients_service.services.data;


import com.example.clients_service.models.Phone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhoneService {

    Phone save(Phone phone);

    List<Phone> findAll();
}
