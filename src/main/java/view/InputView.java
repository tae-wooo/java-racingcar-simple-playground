package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = scanner.nextLine().replaceAll(",\\s*", ",");
        return Arrays.asList(inputName.split(","));
    }

    public static int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException input) {
                System.out.println("회수는 숫자로 입력해 주세요!!");
                scanner.nextLine();
            }
        }
    }
}
