package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MyController {
    ArrayList<Employee> employees = new ArrayList<>();
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employees;
    }
    @GetMapping("/getById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // Return null if employee not found
    }

    @PostMapping("/create")
    public String postMethodName(@RequestBody Employee employee) {
        employees.add(employee);
        return "Employee created successfully";
    }
    

}
