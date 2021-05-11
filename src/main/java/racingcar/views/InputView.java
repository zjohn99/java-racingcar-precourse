package racingcar.views;

import java.util.Scanner;

import static racingcar.views.GameMessages.printAskInputCarListMessage;
import static racingcar.views.GameMessages.printAskTurnNumberInputMessage;
import static utils.InputUtils.inputInteger;
import static utils.InputUtils.inputStringArray;

public class InputView {

    private InputView() {
    }

    public static String[] inputCarList(Scanner sc) {
        String[] carList;

        printAskInputCarListMessage();

        try {
            carList = inputStringArray(sc);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 경주 자동차 정보의 입력을 확인하시기 바랍니다.");
        }

        return carList;
    }

    public static Integer inputTurn(Scanner sc) {
        Integer turn;

        printAskTurnNumberInputMessage();

        try {
            turn = inputInteger(sc);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 정수만 입력할 수 있습니다.");
        }

        return turn;
    }
}
