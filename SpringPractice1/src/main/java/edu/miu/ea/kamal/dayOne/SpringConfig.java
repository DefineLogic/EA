package edu.miu.ea.kamal.dayOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@Import(SpringConfig2.class )
@ImportResource("classpath:config2.xml")
public class SpringConfig {

    @Bean
    public Game game(Vechile vechile){
        return new Game(vechile);
    }
}
