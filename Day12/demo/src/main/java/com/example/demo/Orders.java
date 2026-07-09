package com.example.demo;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productname;
    private int quantity;
    private double price;

    public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getProductname() {
    return productname;
}

public void setProductname(String productname) {
    this.productname = productname;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}
    public Orders() {
    }
    public Orders(Long id, String productname, int quantity, double price) {
        this.id = id;
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
    }
}
