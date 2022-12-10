package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printError(String error) {
        System.out.println(error);
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
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

    public void printWinner(String winner) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(winner);
    }
}
