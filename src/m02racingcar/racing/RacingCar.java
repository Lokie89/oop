package m02racingcar.racing;

import m02racingcar.Car;

public class RacingCar extends Car {
    private int position;

    public RacingCar(String carName) {
        super(carName);
        position = 0;
    }

    public void go() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public void print() {
        System.out.print(carName + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
