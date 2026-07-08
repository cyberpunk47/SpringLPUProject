package com.example.orderservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = getOrderById(id);
        existingOrder.setProductName(orderDetails.getProductName());
        existingOrder.setQuantity(orderDetails.getQuantity());
        existingOrder.setPrice(orderDetails.getPrice());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        Order existingOrder = getOrderById(id);
        orderRepository.delete(existingOrder);
    }

}
