package com.practice.serverB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("service/B")
    public String printService() {
        return "This is Server B!";
    }
}

