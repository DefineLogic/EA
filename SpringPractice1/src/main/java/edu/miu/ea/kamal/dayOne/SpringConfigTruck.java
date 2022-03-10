package edu.miu.ea.kamal.dayOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigTruck {

    @Bean
    public Game game(Vechile vechile){
        return new Game(vechile);
    }

    @Bean
    public Truck asdf(){
        return new Truck(2020,"Tesla","CyberTruck",20000);
    }
}
