package com.cartservice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @GetMapping("/carts")
    public String getCarts() {
        return "Hello, I am a cart from the cart microservice";
    }
}
