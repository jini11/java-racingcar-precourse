package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printError(String error) {
        System.out.println(error);
    }

    public void printMap(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
