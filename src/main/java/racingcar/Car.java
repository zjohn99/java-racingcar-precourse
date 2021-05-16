package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public int getRandomNum() {
        return RandomUtils.nextInt(0, 10);
    }

    public void moveCnt(int num) {
        if (num >= 4) {
            this.position++;
        }
    }

    public void outputRacing() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void liveRacing() {
        moveCnt(getRandomNum());
        outputRacing();
    }

    public int infoPosition() {
        return this.position;
    }

    public String infoName() {
        return this.name;
    }
}
