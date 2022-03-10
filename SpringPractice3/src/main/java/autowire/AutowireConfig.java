package autowire;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireConfig {

    @Bean
    public GameA gameA() {
        return new GameA();
    }

    @Bean
    public CarA carA() {
        return new CarA();
    }

    @Bean
    public BikeA bikeAA() {
        return new BikeA();
    }
}
