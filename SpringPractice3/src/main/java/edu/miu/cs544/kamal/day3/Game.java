package edu.miu.cs544.kamal.day3;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract  class Game implements ApplicationContextAware {

    ApplicationContext applicationContext;

    private Vechile vechile;

    public Game() {
    }

    public Game(Vechile vechile) {
        this.vechile = vechile;
    }

    public void play() {
        vechile.move();
    }
    public abstract Vechile getVechile();

//    public Vechile getVechile() {
//        return this.applicationContext.getBean(Car.class);
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
