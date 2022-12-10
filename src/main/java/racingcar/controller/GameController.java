package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private Car car;
    private RacingGame racingGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingGame = new RacingGame();
    }

    public void start() {
        List<Car> cars = makeCars();
        playGame(inputRound(), cars);
    }

    private List<Car> makeCars() {
        try {
            return makeCar(inputView.readCarName());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return makeCars();
        }
    }

    private List<Car> makeCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int inputRound() {
        try {
            return inputView.readRound();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputRound();
        }
    }

    private void playGame(int round, List<Car> cars) {
        for (int i = 0; i < round; i++) {
            playRound(cars);
        }
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            racingGame.moveOrStop(car);
        }
    }
}
