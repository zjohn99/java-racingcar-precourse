package racingcar.views;

import java.util.Collections;
import racingcar.domain.Car;
import racingcar.domain.Match;

public class OutputView {

    private OutputView() {
    }

    private static void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + String.join("", Collections
            .nCopies(car.getPosition(), "-")));
    }

    public static void printCurrentMatchStatus(Match match) {
        for (Car car : match.getCarList()) {
            printCarStatus(car);
        }

        GameMessages.printEmptyNextLine();
    }

    public static void printMatchWinner(Match match) {
        System.out.println("최종 우승자: " + String.join(", ", match.makeWinnerResult()));
    }
}
