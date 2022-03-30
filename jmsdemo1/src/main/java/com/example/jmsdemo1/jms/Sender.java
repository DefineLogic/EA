package com.example.jmsdemo1.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${springjms.mqName}")
    private String queueName;

    public void send(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }

    public void send2(String message) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };
        jmsTemplate.send(queueName, messageCreator);
    }

    public void send3(String message) {
        MessageCreator messageCreator = (session) -> session.createTextMessage(message);
        jmsTemplate.send(queueName, messageCreator);

    }

}
