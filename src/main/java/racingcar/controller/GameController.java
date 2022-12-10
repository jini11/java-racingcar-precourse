package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private Car car;
    private Cars cars;
    private RacingGame racingGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingGame = new RacingGame();
    }

    public void start() {
        cars = new Cars(makeCars());
        playGame(inputRound());
        outputView.printWinner(cars.calculateWinner());
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

    private void playGame(int round) {
        outputView.printResult();
        for (int i = 0; i < round; i++) {
            playRound();
            outputView.printMap(cars.getCars());
        }
    }

    private void playRound() {
        for (Car car : cars.getCars()) {
            racingGame.moveOrStop(car);
        }
    }
}
