package m02racingcar.racing;

import m02racingcar.Car;
import m02racingcar.RandomNumberGenerator;

public class RacingCar extends Car {
    private int position;

    public RacingCar(String carName) {
        super(carName);
        position = 0;
    }

    public void step() {
        if (canGoing()) {
            go();
        }
    }

    private void go() {
        position += racingCarBrand.getSpeed();
    }

    private boolean canGoing() {
        final int start = 1;
        final int last = 10;
        return RandomNumberGenerator.generate(start, last) > 5;
    }


    public int getPosition() {
        return position;
    }

    public void print() {
        System.out.print(carName + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println("ㆅ");
    }

}
