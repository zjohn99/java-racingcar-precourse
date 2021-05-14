package racingcar;

import java.util.Scanner;
import racingcar.domain.Game;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {

    private static void runGame(Scanner sc) {
        String[] carNameArray = InputView.inputCarList(sc);
        Game game = Game.createGameByCarNameArray(carNameArray);
        int turnCount = InputView.inputTurn(sc);

        OutputView.printExecutionResultUIMessage();
        OutputView.printEmptyNextLine();

        while (turnCount != 0) {
            turnCount--;
            game.runOneTurn();
            game.updateLongestDistance();
            OutputView.printCurrentGameTurnStatus(game);
        }

        OutputView.printMatchWinner(game);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        runGame(scanner);
    }
}
