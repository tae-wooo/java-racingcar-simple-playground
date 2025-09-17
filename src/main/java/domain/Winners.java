package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<String> winners;

    private Winners() {
        this.winners = new ArrayList<>();
    }

    public static Winners winnersCreate() {
        return new Winners();
    }


    public void setWinners(List<String> winnerNames) {
        this.winners.clear();
        this.winners.addAll(winnerNames);
    }


    public List<String> getWinners() {
        return winners;
    }

}

