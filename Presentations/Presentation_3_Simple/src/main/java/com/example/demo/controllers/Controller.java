package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String helloGet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }
}
