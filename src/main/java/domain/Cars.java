package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars() {
        this.cars = new ArrayList<>();
    }

    public static Cars createCars(List<String> carNames) {
        Cars cars = new Cars();
        for (String name : carNames) {
            cars.addCar(Car.createCarByCarName(name));
        }
        return cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
