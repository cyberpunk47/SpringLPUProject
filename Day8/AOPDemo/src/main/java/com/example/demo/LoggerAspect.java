package com.example.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Before("execution(* com.example.demo.MyService.displayMessage(..))")
    public void beforeAdvice() {
        System.out.println("Before method execution");
    }

    
    @After("execution(* com.example.demo.MyService.displayMessage(..))")
    public void afterAdvice() {
        System.out.println("After method execution");
    }
}
