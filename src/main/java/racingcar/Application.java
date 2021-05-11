package racingcar;

import java.util.List;
import java.util.Scanner;
import racingcar.elements.Match;
import racingcar.views.GameMessages;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {

    private static Integer stopRunGameCondition = 0;
    private static Integer minusValuePerTurn = 1;

    private static void runGame(Scanner sc) {
        String[] carNameArray = InputView.inputCarList(sc);
        Integer turnCount = InputView.inputTurn(sc);
        Match match = Match.createMatchByCarNameArray(carNameArray);

        GameMessages.printExecutionResultUIMessage();
        GameMessages.printEmptyNextLine();

        while (turnCount != stopRunGameCondition) {
            turnCount -= minusValuePerTurn;
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
