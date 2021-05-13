package racingcar.views;

import java.util.Collections;
import racingcar.domain.Car;
import racingcar.domain.GameTurn;

public class OutputView {

    private OutputView() {
    }

    private static void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + String.join("", Collections
            .nCopies(car.getPosition(), "-")));
    }

    public static void printCurrentGameTurnStatus(GameTurn gameTurn) {
        for (Car car : gameTurn.getCarList()) {
            printCarStatus(car);
        }

        printEmptyNextLine();
    }

    public static void printMatchWinner(GameTurn gameTurn) {
        System.out.println("최종 우승자: " + String.join(", ", gameTurn.makeWinnerResult()));
    }

    public static void printExecutionResultUIMessage() {
        System.out.println("실행 결과");
    }

    public static void printEmptyNextLine() { System.out.println(); }
}
