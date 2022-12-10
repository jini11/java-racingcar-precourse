package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class GameController {
    private InputView inputView;
    public GameController() {
        inputView = new InputView();
    }

    public void start() {
        List<String> names = inputView.readCarName();
    }
}
