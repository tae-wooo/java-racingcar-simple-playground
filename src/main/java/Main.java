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

        Cars cars = Cars.carsCreate(carNames);
        Winners winners = Winners.winnersCreate();

        GameManage game = new GameManage(cars, winners);

        game.race(roundCount);
        ResultView.printWinners(game.getWinners().getWinners());

    }
}
