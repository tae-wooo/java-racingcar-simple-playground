package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 생성 시 이름이 올바르게 부여되고 위치는 0으로 초기화")
    void should_set_carName_and_initialize_position_when_created() {
        //given
        String carName = "haha";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getCarName()).isEqualTo(carName);
        assertThat(car.getCarPosition()).isEqualTo(0);
    }


    @Test
    @DisplayName("전진 조건(4 이상)을 만족하면 위치가 1 증가")
    void car_move_test() {
        //given
        Car car = new Car("haha");

        //when
        car.move(4);

        //then
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지 조건(3 이하)을 만족하면 위치가 변함X")
    void car_stop_test() {
        //given
        Car car = new Car("haha");

        //when
        car.move(3);

        //then
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

}
