package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    /**
     * Get Orders from the system
     *
     * @return - Returns list of orders
     */
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getRepository().findAll();
    }

    /**
     * Put Orders into the system and gets back specific page index, size, and sort fields
     *
     * @param orders - List orders to be saved into the system
     */
    @PostMapping("/orders")
    public List<Order> addOrders(@RequestBody List<Order> orders) {
        return orderService.getRepository().saveAll(orders);
    }

    /**
     * Get Orders from the system of specific page index, size, and sort fields
     *
     * @return - Returns list of orders
     */
    @GetMapping("/orders/{pageIndex}/{sizeOfPage}/{sortParameter}")
    public Page<Order> getPaginatedOrders(@PathVariable int pageIndex, @PathVariable int sizeOfPage, @PathVariable String sortParameter) {
        return orderService.getRepository().findAll(PageRequest.of(pageIndex, sizeOfPage, Sort.Direction.ASC, sortParameter));
    }

    /**
     * Put Orders into the system and gets back specific page index, size, and sort fields
     *
     * @param orders - List orders to be saved into the system
     */
    @PostMapping("/orders/{pageIndex}/{sizeOfPage}/{sortParameter}")
    public Page<Order> addPaginatedOrders(@RequestBody List<Order> orders, @PathVariable int pageIndex, @PathVariable int sizeOfPage, @PathVariable String sortParameter) {
        orderService.getRepository().saveAll(orders);
        return orderService.getRepository().findAll(PageRequest.of(pageIndex, sizeOfPage, Sort.Direction.ASC, sortParameter));
    }
}