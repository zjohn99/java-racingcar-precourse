package racingcar.domain;

import static racingcar.domain.Car.createCarListByStringArray;
import static racingcar.tools.GameRandomTool.carMoveVerifier;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private Integer longestDistanceInMatch = 0;
    private List<Car> carList;

    private Match() {
    }

    private Match(List<Car> carList) {
        this.carList = carList;
    }

    public static Match createMatchByCarNameArray(String[] carNames) {
        return new Match(createCarListByStringArray(carNames));
    }

    private Integer getLongestDistanceInMatch() {
        return this.longestDistanceInMatch;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    private void updateLongestDistance(Car car) {
        this.longestDistanceInMatch = Math.max(car.getPosition(), this.getLongestDistanceInMatch());
    }

    public void runOneTurn() {
        for (Car car : carList) {
            if (carMoveVerifier()) {
                car.moveCar();
                this.updateLongestDistance(car);
            }
        }
    }

    public List<String> makeWinnerResult() {
        List<String> result = new ArrayList<>();

        for (Car car : this.getCarList()) {
            if (car.getPosition() == this.getLongestDistanceInMatch()) {
                result.add(car.getName());
            }
        }

        return result;
    }
}
