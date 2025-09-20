package com.exception_poc.demo.service;

import com.exception_poc.demo.exception.DatabaseException;
import com.exception_poc.demo.exception.OrderNotFoundException;
import com.exception_poc.demo.model.Order;
import com.exception_poc.demo.repository.OrderRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long id) {
        try {
            return orderRepository.findById(id)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + id));
        } catch (DataAccessException e) {
            throw new DatabaseException("Database error while fetching order " + id, e);
        }
    }
}
