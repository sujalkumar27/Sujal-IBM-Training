package com.example.rdsdemo.controller;

import com.example.rdsdemo.model.Employee;
import com.example.rdsdemo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return repo.save(emp);
    }
}
