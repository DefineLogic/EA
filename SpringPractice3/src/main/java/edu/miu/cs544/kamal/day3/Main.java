package edu.miu.cs544.kamal.day3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
               ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");

        Game game1 = (Game) springContext.getBean(Game.class);
        Game game2 = (Game) springContext.getBean(Game.class);
        Game game3 = (Game) springContext.getBean(Game.class);
        System.out.println(game1);
        System.out.println(game2);
        System.out.println(game3);

        System.out.println(game1.getVechile());
        System.out.println(game2.getVechile());
        System.out.println(game3.getVechile());

        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) springContext;
        configurableApplicationContext.close();


//        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
//        Game game = (Game) springContext.getBean("ts");
        ProtoTypeDestroy prototypeDestroy = springContext.getBean(ProtoTypeDestroy.class);
        try {
            prototypeDestroy.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
