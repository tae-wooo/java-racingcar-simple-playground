package racingcar;

public class Car {
    private static final int MOVE_STANDARD = 4;//기준값 상수화

    private String carName;
    private int carPosition;

    public Car(String name) {
        this.carName = name;
        this.carPosition = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD) {
            carPosition++;
        }
    }

    public int getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }
}
