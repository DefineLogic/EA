package edu.miu.ea.kamal.dayOne;

public class Truck implements  Vechile{

    private int year;
    private String maker;
    private String model;
    private int millage;

    public Truck(int year, String maker, String model, int millage){
        this.year = year;
        this.maker = maker ;
        this.model = model;
        this.millage = millage;
    }

    @Override
    public void move() {
        System.out.println("Truck moving at 60 mph");
    }
}
