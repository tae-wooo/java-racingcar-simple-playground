package racingcar;

import java.util.Random;

public class Car {
    private static final int MOVE_STANDARD = 4;//기준값 상수화

    //필드
    String carName;
    private int carPosition = 0;

    //랜덤 객체 생성
    Random random = new Random();

    public Car (String name){
        this.carName = name;
    }

    private int getNumber(){
        return random.nextInt(10);
    }

    public void move (){
        if (getNumber() >= MOVE_STANDARD){
            carPosition++;
        }
    }

    public int getCarPosition(){
        return carPosition;
    }

    public String getCarName(){
        return carName;
    }
}
