package util;

import java.util.Random;

public class Generater {
    private static final Random random = new Random();

    public static int generateNumber() {
        return random.nextInt(10);
    }
}
