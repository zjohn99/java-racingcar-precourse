package racingcar.views;

public class GameMessages {

    private GameMessages() {
    }

    public static void printAskInputCarListMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAskTurnNumberInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printExecutionResultUIMessage() {
        System.out.println("실행 결과");
    }
}
