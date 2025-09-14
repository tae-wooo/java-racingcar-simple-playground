package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManage {
    private ArrayList<Car> cars = new ArrayList<>();

    public void addCar (Car car){
        this.cars.add(car);
    }

   private void raceOneRound(){
        for (Car car : cars){
            car.move();
        }
    }

    public void race (int round) {
        for (int i = 0 ; i < round;i++){
            raceOneRound();
        }
    }

    public void findWinner() {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getCarPosition()) {
                max = car.getCarPosition();
            }
        }

        for (Car car : cars){
            if (car.getCarPosition() == max){
                System.out.println(car.getCarName());
            }
        }
    }
}
