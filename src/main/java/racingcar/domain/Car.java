package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int moveDistancePerOrder = 1;
    private static final int carNameMaximumLength = 5;

    private final String name;
    private int position = 0;

    private Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static List<Car> createCarListByStringArray(String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    private void validateNameLength(String name) {
        if (name.length() > carNameMaximumLength) {
            throw new IllegalArgumentException("[ERROR]: 각 차량의 길이가 5를 초과하면 허용하지 않습니다.");
        }
    }

    public void moveCar() {
        this.position += moveDistancePerOrder;
    }
}
