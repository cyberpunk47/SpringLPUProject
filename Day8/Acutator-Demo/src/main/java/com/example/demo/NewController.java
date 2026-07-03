package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {
    
    @GetMapping("/testing")
    public String hello() {
        return "Actutor working !";
    }
}
