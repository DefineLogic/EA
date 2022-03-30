package com.example.jmsdemo1.controller;

import com.example.jmsdemo1.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @Autowired
    private Sender sender;

    @GetMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable String message){
        sender.send(message);
    }

    @GetMapping("/sendMessage2/{message}")
    public void sendMessage2(@PathVariable String message){
        sender.send2(message);
    }
}
