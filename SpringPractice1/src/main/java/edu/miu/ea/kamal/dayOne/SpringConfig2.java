package edu.miu.ea.kamal.dayOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig2 {

    @Bean
    public Vechile vechile(){
        return new Bike();
    }
}
