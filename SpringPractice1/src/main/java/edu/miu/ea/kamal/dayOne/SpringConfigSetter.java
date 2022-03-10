package edu.miu.ea.kamal.dayOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigSetter {

    @Bean
    public Game game(Vechile vechile){
        return new Game(vechile);
    }

    @Bean
    public Bike bike(){
       Bike bike = new Bike();
       bike.setBrand("BMX");
       bike.setTireSize(33);
       return bike;
    }
}
