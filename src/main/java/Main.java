import domain.GameManage;
import domain.Cars;
import domain.Winners;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cars cars = InputView.inputCarName();
        int roundCount = InputView.inputRound();
        GameManage game = new GameManage(cars);
        Winners winners = game.race(roundCount);
        ResultView.printWinners(winners.getWinners());
    }
}
