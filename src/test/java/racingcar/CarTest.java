import racingcar.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 생성 시 이름이 올바르게 부여되고 위치는 0으로 초기화")
    void car_test() {

        String carName = "haha";

        Car car = new Car(carName);

        assertThat(car.getCarName()).isEqualTo(carName);

        assertThat(car.getCarPosition()).isEqualTo(0);

    }


    @Test

    @DisplayName("전진 조건(4 이상)을 만족하면 위치가 1 증가")
    void car_move_test() {

        Car car = new Car("haha");

        car.move(4);

        assertThat(car.getCarPosition()).isEqualTo(1);
    }


    @Test

    @DisplayName("정지 조건(3 이하)을 만족하면 위치가 변함X")
    void car_stop_test() {

        Car car = new Car("haha");

        car.move(3);

        assertThat(car.getCarPosition()).isEqualTo(0);

    }

}
