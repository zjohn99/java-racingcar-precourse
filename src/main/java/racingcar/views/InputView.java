package racingcar.views;

import static utils.InputUtils.inputInteger;
import static utils.InputUtils.inputStringArray;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String[] inputCarList(Scanner sc) {
        String[] carList;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            carList = inputStringArray(sc);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 경주 자동차 정보의 입력을 확인하시기 바랍니다.");
        }

        return carList;
    }

    public static int inputTurn(Scanner sc) {
        int turn;

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            turn = inputInteger(sc);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 정수만 입력할 수 있습니다.");
        }

        return turn;
    }
}
