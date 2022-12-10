package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String calculateWinner() {
        int max = calculateMax();
        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }

    private int calculateMax() {
        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max().getAsInt();
    }
}
