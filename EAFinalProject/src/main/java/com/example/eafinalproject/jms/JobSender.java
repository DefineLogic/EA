package com.example.eafinalproject.jms;

import com.example.eafinalproject.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class JobSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${springjms.mqName}")
    private String queueName;

    public void send(Job job) {
        jmsTemplate.convertAndSend(queueName, job);
    }

}
