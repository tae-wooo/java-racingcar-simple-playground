package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;


public class GameManage {

    Random random = new Random();

    private final List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int createNumber() {
        return random.nextInt(10);
    }

    public void carMove(Car car, int randomNumber) {
        car.move(randomNumber);
    }

    public void raceOneRound() {
        for (Car car : cars) {
            carMove(car, createNumber());
        }
    }

    private int maxPosition() {
        return cars.stream().mapToInt(Car::getCarPosition).max().orElse(0);
    }

    public void findWinner() {
        this.winners = cars.stream().filter(car -> car.getCarPosition() == maxPosition()).map(Car::getCarName).collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return this.winners;
    }

    public List<String> race(int round) {
        for (int i = 0; i < round; i++) {
            raceOneRound();
        }
        findWinner();
        return getWinners();
    }

}
