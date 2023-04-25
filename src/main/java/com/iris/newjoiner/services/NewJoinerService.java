package com.iris.newjoiner.services;

import com.iris.newjoiner.model.NewJoiners;
import com.iris.newjoiner.repository.NewJoinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewJoinerService {

    @Autowired
    private NewJoinerRepository newJoinerRepository;

    public List<NewJoiners> getAllNewJoiners() {
        return newJoinerRepository.findAll();
    }

    public NewJoiners getNewJoinerById(int id) {
        return newJoinerRepository.findById(id).get();
    }

    public NewJoiners saveOrUpdate(NewJoiners newJoiners) {
        return newJoinerRepository.save(newJoiners);
    }

    public void delete(int id) {
        newJoinerRepository.deleteById(id);
    }
}
