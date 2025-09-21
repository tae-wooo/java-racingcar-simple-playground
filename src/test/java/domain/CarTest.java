package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    void 자동차는이름과초기위치를가진다() {
        // given
        String name = "car1";

        // when
        Car car = Car.createCarByCarName(name);

        // then
        assertThat(car.getCarName()).isEqualTo("car1");
        assertThat(car.getCarPosition()).isZero();
    }

    @Test
    void 랜덤숫자가4이상이면전진할수있다() {
        // given
        Car car = Car.createCarByCarName("car1");

        // when
        for (int i = 0; i < 10; i++) {
            car.moveCar();
        }

        // then
        assertThat(car.getCarPosition()).isGreaterThanOrEqualTo(0);
    }
}
