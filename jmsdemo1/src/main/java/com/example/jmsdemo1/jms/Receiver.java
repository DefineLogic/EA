package com.example.jmsdemo1.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "${springjms.mqName}")
    public void receive(String message) {
        System.out.println("Received Message:" + message);
    }
}
