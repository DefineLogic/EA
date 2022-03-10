//package edu.miu.cs544.kamal.day3;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//public class SpringConfig   {
//
//
//    @Bean
//    @Scope(value = "singleton")
//    public Game game() {
//        Game game = new Game(vechile());
//        return game;
//    }
//    @Bean
//    @Scope(value = "prototype")
//    public Vechile vechile(){
//        return new Car();
//    }
//
//}
