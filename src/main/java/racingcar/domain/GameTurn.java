package racingcar.domain;

import racingcar.tools.GameRandomTool;

import java.util.ArrayList;
import java.util.List;

public class GameTurn {

    private Integer longestDistanceInMatch = 0;
    private List<Car> carList;

    private GameTurn() {
    }

    private GameTurn(List<Car> carList) {
        this.carList = carList;
    }

    public static GameTurn createMatchByCarNameArray(String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return new GameTurn(carList);
    }

    private Integer getLongestDistanceInMatch() {
        return this.longestDistanceInMatch;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void updateLongestDistance() {
        for (Car car : carList) {
            this.longestDistanceInMatch = Math.max(car.getPosition(), this.getLongestDistanceInMatch());
        }
    }

    public void runOneTurn() {
        for (Car car : carList) {
            if (GameRandomTool.carMoveVerifier()) {
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
