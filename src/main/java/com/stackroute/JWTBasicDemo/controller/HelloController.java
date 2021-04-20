package com.stackroute.JWTBasicDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/msg")
    public String getData(){
        return " Happy Learning";
    }
}
