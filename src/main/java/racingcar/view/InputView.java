package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_ROUND = "시도할 회수는 몇회인가요?";
    public List<String> readCarName() {
        System.out.println(INPUT_CAR_NAME);
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int readRound() {
        System.out.println(INPUT_ROUND);
        String round = Console.readLine();
        validateRound(round);
        System.out.println();
        return Integer.parseInt(round);
    }

    private void validateRound(String round) {
        if (validateType(round)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        if (validateRange(Integer.parseInt(round))) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private boolean validateType(String round) {
        return !round.matches("^[0-9]*$");
    }

    private boolean validateRange(int round) {
        return round <= 0;
    }
}
