package racingcar;

import java.util.Scanner;
import racingcar.elements.Match;
import racingcar.views.GameMessages;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {

    private static void runGame(Scanner sc) {
        String[] carNameArray = InputView.inputCarList(sc);
        Match match = Match.createMatchByCarNameArray(carNameArray);
        int turnCount = InputView.inputTurn(sc);

        GameMessages.printExecutionResultUIMessage();
        GameMessages.printEmptyNextLine();

        while (turnCount != 0) {
            turnCount--;
            match.runOneTurn();
            OutputView.printCurrentMatchStatus(match);
        }

        OutputView.printMatchWinner(match);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        runGame(scanner);
    }
}
