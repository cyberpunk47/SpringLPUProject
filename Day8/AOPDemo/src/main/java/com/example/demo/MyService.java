package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void displayMessage(){
        System.out.println("AOP working !");
    }
}
