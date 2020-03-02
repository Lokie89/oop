package m02racingcar;

import m02racingcar.exception.ParsingException;
import m02racingcar.racing.RacingCarBrand;

public class Car {
    protected final String carName;
    protected final RacingCarBrand racingCarBrand;

    public Car(String carName) {
        this.carName = carName;
        racingCarBrand = setCarBrand();
    }

    private RacingCarBrand setCarBrand() {
        String info = "차 브랜드를 고르세요.\n";
        for (RacingCarBrand racingCarBrand : RacingCarBrand.values()) {
            info += (racingCarBrand.ordinal() + 1) + ". " + racingCarBrand.name() + "\n";
        }
        int index;
        try {
            index = Parsing.strToInteger(new CustomScanner(info).getFirstResponse()[0]);
        } catch (ParsingException e) {
            e.printMessage();
            return setCarBrand();
        }
        return RacingCarBrand.values()[index - 1];
    }

    public boolean isSameCarName(String carName) {
        return this.carName.equals(carName);
    }

}
