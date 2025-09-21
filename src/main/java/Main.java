import domain.GameManage;
import domain.Cars;
import domain.Winners;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarName();
        int roundCount = InputView.inputRound();

        Cars cars = Cars.createCars(carNames);

        GameManage game = new GameManage(cars);

        Winners winners = game.race(roundCount);
        ResultView.printWinners(winners.getWinners());
    }
}
