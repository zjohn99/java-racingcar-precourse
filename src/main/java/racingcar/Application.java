package racingcar;

import java.util.Scanner;
import racingcar.domain.GameTurn;
import racingcar.views.GameMessages;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {

    private static void runGame(Scanner sc) {
        String[] carNameArray = InputView.inputCarList(sc);
        GameTurn gameTurn = GameTurn.createMatchByCarNameArray(carNameArray);
        int turnCount = InputView.inputTurn(sc);

        GameMessages.printExecutionResultUIMessage();
        GameMessages.printEmptyNextLine();

        while (turnCount != 0) {
            turnCount--;
            gameTurn.runOneTurn();
            OutputView.printCurrentGameTurnStatus(gameTurn);
        }

        OutputView.printMatchWinner(gameTurn);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        runGame(scanner);
    }
}
