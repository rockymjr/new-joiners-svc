package com.iris.newjoiner.services;

import com.iris.newjoiner.dto.NewJoinersDto;
import com.iris.newjoiner.model.Employee;
import com.iris.newjoiner.model.NewJoiner;
import com.iris.newjoiner.repository.EmployeeRepository;
import com.iris.newjoiner.repository.NewJoinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewJoinerService {

    @Autowired
    private NewJoinerRepository newJoinerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<NewJoiner> getAllNewJoiners() {
        return newJoinerRepository.findAll();
    }

    public NewJoiner getNewJoinerById(int id) {
        return newJoinerRepository.findById(id).get();
    }

    public NewJoiner saveOrUpdate(NewJoinersDto newJoinerDto) {
        NewJoiner newJoiner = newJoinerDto.getNewJoiner();
        Optional<Employee> hrSpocsOptional = employeeRepository.findById(newJoinerDto.getHrSpocId());
        if (!hrSpocsOptional.isPresent()) {
            // Return a 404 response if the manager entity is not found
        }
        newJoiner.setHrSpoc(hrSpocsOptional.get());

        Optional<Employee> managerOptional = employeeRepository.findById(newJoinerDto.getManagerId());
        if (!managerOptional.isPresent()) {
            // Return a 404 response if the manager entity is not found
        }
        newJoiner.setManager(managerOptional.get());
        return newJoinerRepository.save(newJoiner);
    }

    public void delete(int id) {
        newJoinerRepository.deleteById(id);
    }
}
