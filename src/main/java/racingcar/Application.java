package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static Car[] cars;
    public static String[] splitCars;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = scanner.nextLine();
        splitCars = inputCars.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int attempt = scanner.nextInt();

        infoCars();

        System.out.println("실행 결과");

        for (int i = 0; i < attempt; i++) {
            oneRace();
        }
        System.out.print("최종 우승자 : ");
        List<String> nameOfWinner = findWinnerName(findWinnerCnt());

        for (int i = 0; i < nameOfWinner.size(); i++) {
            System.out.print(nameOfWinner.get(i));
            if (i < nameOfWinner.size() - 1) {
                System.out.print(", ");
            }
        }

    }

    public static List<String> findWinnerName(int winnerIdx) {
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < splitCars.length; i++) {
            if (winnerIdx == cars[i].infoPosition()) {
                winner.add(cars[i].infoName());
            }
        }
        return winner;
    }

    private static int findWinnerCnt() {
        int maxVal = 0;

        for (int i = 0; i < splitCars.length; i++) {
            if (maxVal < cars[i].infoPosition()) {
                maxVal = cars[i].infoPosition();
            }
        }
        return maxVal;

    }

    public static void oneRace() {
        for (int i = 0; i < splitCars.length; i++) {
            cars[i].liveRacing();
        }
        System.out.println();
    }

    public static void infoCars() {
        cars = new Car[splitCars.length];
        for (int i = 0; i < splitCars.length; i++) {
            cars[i] = new Car(splitCars[i]);
        }
    }


}
