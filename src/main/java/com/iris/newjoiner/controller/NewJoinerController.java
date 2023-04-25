package com.iris.newjoiner.controller;

import com.iris.newjoiner.model.NewJoiners;
import com.iris.newjoiner.services.NewJoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/newjoiners")
@CrossOrigin(origins = "http://localhost:3000")
public class NewJoinerController {


    private final NewJoinerService newJoinerService;

    @Autowired
    public NewJoinerController(NewJoinerService newJoinerService) {
        this.newJoinerService = newJoinerService;
    }


    @GetMapping()
    public List<NewJoiners> getAllNewJoiners() {
        return newJoinerService.getAllNewJoiners();
    }

    @RequestMapping("/{id}")
    public NewJoiners getNewJoinerById(@PathVariable int id) {
        return newJoinerService.getNewJoinerById(id);
    }

    @PutMapping
    public NewJoiners saveNewJoiners(@RequestBody NewJoiners newJoiners) {
        return newJoinerService.saveOrUpdate(newJoiners);
    }

    @PostMapping
    public NewJoiners updateNewJoiners(@RequestBody NewJoiners newJoiners) {
        return newJoinerService.saveOrUpdate(newJoiners);
    }

    @DeleteMapping
    public void deleteNewJoinersById(int id) {
        newJoinerService.delete(id);
    }
}
