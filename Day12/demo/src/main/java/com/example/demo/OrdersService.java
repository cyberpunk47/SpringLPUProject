package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    // Get all orders
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // Get order by ID
    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    // Create order
    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    // Update order
    public Orders updateOrder(Long id, Orders updatedOrder) {
        return ordersRepository.findById(id)
                .map(order -> {
                    order.setProductname(updatedOrder.getProductname());
                    order.setQuantity(updatedOrder.getQuantity());
                    order.setPrice(updatedOrder.getPrice());
                    return ordersRepository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    // Delete order
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}