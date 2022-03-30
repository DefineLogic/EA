package com.example.eafinalproject.controller;

import com.example.eafinalproject.EaFinalProjectApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuntimeProfileController {
    @PutMapping("/restart/{env}")
    public void restart(@PathVariable String env) {
        EaFinalProjectApplication.restart(env);
    }
}
