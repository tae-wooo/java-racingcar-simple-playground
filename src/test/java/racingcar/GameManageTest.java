package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameManageTest {
    @Test
    @DisplayName("자동차 생성")
    void addCarTest() {
        //given
        GameManage gameManager = new GameManage();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        //when
        gameManager.addCar(car1);
        gameManager.addCar(car2);
        gameManager.addCar(car3);

        //then
        assertEquals(3, gameManager.getCars().size());
    }


    @Test
    @DisplayName("생성된 숫자가 0 이상 9 이하인지 확인")
    void createNumber_Test() {
        GameManage gameManager = new GameManage();
        int randomNumber = gameManager.createNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("carMove가 4 이상의 값으로 자동차를 전진시키는지 확인")
    void carMove_move_Test() {
        // given
        GameManage gameManager = new GameManage();
        Car car = new Car("testCar");
        int randomNumber = 4;

        // when
        gameManager.carMove(car, randomNumber);

        // then
        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("carMove가 3 이하의 값으로 자동차를 정지시키는지 확인")
    void carMove_stop_Test() {
        // given
        GameManage gameManager = new GameManage();
        Car car = new Car("testCar");
        int randomNumber = 3;

        // when
        gameManager.carMove(car, randomNumber);

        // then
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("우승자가 한 명일 경우를 테스트")
    void findWinner_oneWinner() {
        // given
        GameManage gameManager = new GameManage();
        Car car1 = new Car("winner");
        Car car2 = new Car("loser1");
        Car car3 = new Car("loser2");

        gameManager.addCar(car1);
        gameManager.addCar(car2);
        gameManager.addCar(car3);

        // car1만 전진하도록 위치를 수동으로 조작
        car1.move(4);
        car2.move(3);
        car3.move(2);

        // when
        gameManager.findWinner();
        List<String> winners = gameManager.getWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo("winner");
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우를 테스트")
    void findWinner_multipleWinners() {
        // given
        GameManage gameManager = new GameManage();
        Car car1 = new Car("winner1");
        Car car2 = new Car("winner2");
        Car car3 = new Car("loser");

        gameManager.addCar(car1);
        gameManager.addCar(car2);
        gameManager.addCar(car3);

        car1.move(4);
        car2.move(5);
        car3.move(2);

        // when
        gameManager.findWinner();
        List<String> winners = gameManager.getWinners();

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactlyInAnyOrder("winner1", "winner2");
    }
}
