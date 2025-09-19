package domain;

import util.Generater;


public class Car {
    private static final int STANDARD = 4;

    private final String carName;
    private int carPosition;

    private Car(String carName) {
        this.carName = carName;
        this.carPosition = 0;
    }

    public static Car namePositionOf(String carName) {
        return new Car(carName);
    }

    public void move() {
        int randomNumber = Generater.generateNumber();
        if (randomNumber >= STANDARD) {
            carPosition++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
