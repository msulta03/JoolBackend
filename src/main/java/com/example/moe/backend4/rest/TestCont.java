package com.example.moe.backend4.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCont {

    @GetMapping("/")
    public String helloWolrd(){
        return "Hello Ya ged3aaan, the time on the server is " + LocalDateTime.now();
    }
}