package edu.miu.ea.kamal.dayOne;

public class Bike implements Vechile{
    private int tireSize;
    private String brand;

    public Bike(){

    }
    public Bike(String brand) {
        this.brand = brand;
    }

    @Override
    public void move() {
        System.out.println("Moving at 10 mph with tire "+ this.brand +" and size "+ this.tireSize);
    }

    public static boolean isBeanInstantiated = false;

    public void postConstruct() {
        isBeanInstantiated = true;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
}
