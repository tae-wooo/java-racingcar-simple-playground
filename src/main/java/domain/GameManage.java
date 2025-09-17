package domain;

import view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class GameManage {
    private final Cars cars;
    private final Winners winners;

    public GameManage(Cars cars, Winners winners) {
        this.cars = cars;
        this.winners = winners;
    }

    public void raceOneRound() {
        for (Car car : cars.getCars()) {
            car.move();
        }
    }

    public void race(int round) {
        for (int i = 0; i < round; i++) {
            raceOneRound();
            ResultView.printRoundResult(cars.getCars());
        }
        findWinner();
    }

    private int maxPosition() {
        return cars.getCars().stream().mapToInt(Car::getCarPosition).max().orElse(0);
    }

    public void findWinner() {
        List<String> winnerNames = cars.getCars().stream()
                .filter(car -> car.getCarPosition() == maxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());

        winners.setWinners(winnerNames);
    }

    public Winners getWinners() {
        return winners;
    }
}
