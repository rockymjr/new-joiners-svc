package com.iris.newjoiner.services;

import com.iris.newjoiner.model.Employee;
import com.iris.newjoiner.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllHrSpocs() {
        return employeeRepository.findByIsHrSpocsTrue();
    }

    public List<Employee> getAllManagers() {
        return employeeRepository.findByIsManagerTrue();
    }
}
