package domain;

import view.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameManage {
    private final Cars cars;

    public GameManage(Cars cars) {
        this.cars = cars;
    }

    public void raceOneRound() {
        for (Car car : cars.getCars()) {
            car.moveCar();
        }
    }

    public Winners race(int round) {
        for (int i = 0; i < round; i++) {
            raceOneRound();
            ResultView.printRoundResult(cars.getCars());
        }
        return createWinners();
    }

    private Map<Integer, List<Car>> groupPosition() {
        return cars.getCars().stream().collect(Collectors.groupingBy(Car::getCarPosition));
    }

    public Winners createWinners() {
        Map<Integer, List<Car>> carsByPosition = groupPosition();

        List<Car> winnersGroup = carsByPosition.entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());

        List<String> winnerNames = winnersGroup.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        return Winners.of(winnerNames);
    }
}
