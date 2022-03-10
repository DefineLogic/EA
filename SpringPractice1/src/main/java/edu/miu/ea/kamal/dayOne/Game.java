package edu.miu.ea.kamal.dayOne;

public class Game {

    private Vechile vechile;

    public Game(Vechile vechile) {
        this.vechile = vechile;
    }

    public void play(){
        this.vechile.move();
    }
}
