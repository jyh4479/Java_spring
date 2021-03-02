package com.practice.serverUp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("service/up")
    public String printService() {
        return "This is Server Up!";
    }
}