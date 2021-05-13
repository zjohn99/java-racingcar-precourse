package racingcar.domain;

import java.util.Collections;
import racingcar.tools.GameRandomTool;

import java.util.ArrayList;
import java.util.List;

public class GameTurn {

    private static int minimumRequirementNumberForCarMove = 4;

    private int longestDistanceInMatch = 0;
    private List<Car> carList;

    private GameTurn() {
    }

    private GameTurn(List<Car> carList) {
        validateCarNamesArray(carList);
        this.carList = carList;
    }

    public static GameTurn createMatchByCarNameArray(String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return new GameTurn(carList);
    }

    private void validateCarNamesArray(List<Car> carList) {
        if (carList.size() == 0) {
            throw new IllegalArgumentException("[ERROR]: 비어있는 경주 자동차 목록은 허용하지 않습니다.");
        }
    }

    private List<Car> getCarList() {
        return Collections.unmodifiableList(this.carList);
    }

    private int getLongestDistanceInMatch() {
        return this.longestDistanceInMatch;
    }

    private boolean isCarMoveAble(int number) {
        return number >= minimumRequirementNumberForCarMove;
    }

    public void updateLongestDistance() {
        for (Car car : carList) {
            this.longestDistanceInMatch = Math
                .max(car.getPosition(), getLongestDistanceInMatch());
        }
    }

    public void runOneTurn() {
        for (Car car : carList) {
            if (isCarMoveAble(GameRandomTool.makeGameRandomNumber())) {
                car.moveCar();
            }
        }
    }

    public List<String> makeWinnerResult() {
        List<String> result = new ArrayList<>();

        for (Car car : this.getCarList()) {
            if (car.getPosition() == getLongestDistanceInMatch()) {
                result.add(car.getName());
            }
        }

        return result;
    }
}
