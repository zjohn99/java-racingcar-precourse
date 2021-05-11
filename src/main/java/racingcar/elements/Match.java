package racingcar.elements;

import static racingcar.tools.GameRandomTool.carMoveVerifier;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private Integer longestDistance = 0;
    private List<Car> carList;

    private Match() {
    }

    public Match(List<Car> carList) {
        this.carList = carList;
    }

    private Integer getLongestDistance() {
        return this.longestDistance;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    private void updateLongestDistance(Car car) {
        this.longestDistance = Math.max(car.getPosition(), this.longestDistance);
    }

    public List<String> makeWinnerResult() {
        List<String> result = new ArrayList<>();

        for (Car car : this.getCarList()) {
            if (car.getPosition() == this.getLongestDistance()) {
                result.add(car.getName());
            }
        }

        return result;
    }

    public void runOneMatch() {
        for (Car car : carList) {
            if (carMoveVerifier()) {
                car.moveCar();
                this.updateLongestDistance(car);
            }
        }
    }
}
