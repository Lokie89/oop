package m02racingcar;

public class Car {
    protected final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public boolean isSameCarName(String carName) {
        return this.carName.equals(carName);
    }

}
