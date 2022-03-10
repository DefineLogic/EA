package edu.miu.cs544.kamal.dayTwo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(initMethod = "customInit")
    public TicketingService ticketingService(){
        return new TicketingService(printService());
    }

    @Bean(initMethod = "customInit")
    public PrintService printService(){
        return new PrintService();
    }
}
