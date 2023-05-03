package com.iris.newjoiner.controller;

import com.iris.newjoiner.dto.NewJoinersDto;
import com.iris.newjoiner.model.NewJoiner;
import com.iris.newjoiner.services.NewJoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public List<NewJoiner> getAllNewJoiners() {
        return newJoinerService.getAllNewJoiners();
    }

    @RequestMapping("/{id}")
    public NewJoiner getNewJoinerById(@PathVariable int id) {
        return newJoinerService.getNewJoinerById(id);
    }

    @PutMapping
    public NewJoiner saveNewJoiners(@RequestBody NewJoinersDto newJoiners) {
        return newJoinerService.saveOrUpdate(newJoiners);
    }

    @PostMapping
    public ResponseEntity<NewJoiner> updateNewJoiners(@RequestBody NewJoinersDto newJoinersDto) {
        NewJoiner newJoiner = newJoinerService.saveOrUpdate(newJoinersDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newJoiner.getId())
                .toUri();
        return ResponseEntity.created(location).body(newJoiner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNewJoinersById(@PathVariable int id) {
        try {
            newJoinerService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
