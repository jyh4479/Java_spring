package com.practice.serverDown;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("service/down")
    public String printService() {
        return "This is Server Down!";
    }
}
