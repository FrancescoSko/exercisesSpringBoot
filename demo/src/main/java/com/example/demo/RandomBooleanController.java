package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/esercizi-develhope")
public class RandomBooleanController {
    @GetMapping("/random-boolean")
    public ResponseEntity<String> getRandomBooleanResponse() {

        Boolean randomBoolean = new Random().nextBoolean();

        if (randomBoolean) {
            return ResponseEntity.ok("The boolean is true");
        } else {
            return ResponseEntity.badRequest().body("The boolean is false");

        }
    }
}