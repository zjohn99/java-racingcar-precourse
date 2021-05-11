package racingcar.elements;

public class Car {

    private static final int moveDistancePerOrder = 1;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        this.position += moveDistancePerOrder;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
