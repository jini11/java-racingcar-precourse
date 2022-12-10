package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class RacingGame {

    public void moveOrStop(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            move(car);
        }
    }

    private void move(Car car) {
        car.move();
    }
}
