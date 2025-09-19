package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getCarPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다");
    }

}
