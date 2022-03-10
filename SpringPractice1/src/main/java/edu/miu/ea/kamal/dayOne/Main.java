package edu.miu.ea.kamal.dayOne;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext springContext = new ClassPathXmlApplicationContext("mixedConfig.xml");
//        Game game = (Game)springContext.getBean("game");

       ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfigTruck.class);
        //ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfigSetter.class);
        Game game = springContext.getBean(Game.class);

       // BeanFactoryPostProcessor
        //BeanPostProcessor

//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
//        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("config.xml"));
        //System.out.println("Is Bean Initialized"+Bike.isBeanInstantiated);
//        Game game = defaultListableBeanFactory.getBean(Game.class);

        game.play();


    }
}
