package com.example.ecommerce.model.services;

import com.example.ecommerce.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public OrderRepository getRepository() {
        return repository;
    }
}