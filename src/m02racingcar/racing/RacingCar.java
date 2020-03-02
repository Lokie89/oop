package m02racingcar.racing;

import m02racingcar.Car;
import m02racingcar.CustomScanner;
import m02racingcar.Parsing;
import m02racingcar.exception.ParsingException;

public class RacingCar extends Car {
    private int position;
    private CarBrand carBrand;

    public RacingCar(String carName) {
        super(carName);
        position = 0;
        setCarBrand();
    }

    private void setCarBrand() {
        String info = "차 브랜드를 고르세요.\n";
        for (CarBrand carBrand : CarBrand.values()) {
            info += (carBrand.ordinal() + 1) + ". " + carBrand.name() + "\n";
        }
        int index;
        try {
            index = Parsing.strToInteger(new CustomScanner(info).getFirstResponse()[0]);
        } catch (ParsingException e) {
            e.printMessage();
            setCarBrand();
            return;
        }
        carBrand = CarBrand.values()[index - 1];
    }

    public void go() {
        position += carBrand.getSpeed();
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
