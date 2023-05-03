package com.iris.newjoiner.controller;

import com.iris.newjoiner.model.Employee;
import com.iris.newjoiner.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);
    }

    @PostMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/type/{type}")
    public List<Employee> getEmployeeByType(@PathVariable String type) {
        if (type != null && type.equalsIgnoreCase("manager"))
            return employeeService.getAllManagers();
        else if (type != null && type.equalsIgnoreCase("hr"))
            return employeeService.getAllHrSpocs();
        return null;
    }
}
