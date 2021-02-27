package com.practice.serverA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("service/A")
    public String printService() {
        return "This is Server A!";
    }
}
