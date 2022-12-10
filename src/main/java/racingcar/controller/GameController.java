package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;

public class GameController {
    private InputView inputView;
    private Car car;
    public GameController() {
        inputView = new InputView();
    }

    public void start() {
        List<String> carNames = inputView.readCarName();
        makeCar(carNames);
    }

    private void makeCar(List<String> carNames) {
        for (String carName : carNames) {
            car = new Car(carName);
        }
    }
}
