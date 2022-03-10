package autowire;

import org.springframework.beans.factory.annotation.Autowired;

public class GameA {
    @Autowired
    private CarA carA;
    @Autowired(required = false)
    private BikeA bikeA;

    public void play() {
        if (carA != null) {
            carA.move();
        }
        if (bikeA != null) {
            bikeA.move();
        }
    }
}
