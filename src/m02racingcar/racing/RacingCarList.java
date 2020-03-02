package m02racingcar.racing;

import m02racingcar.CustomScanner;
import m02racingcar.Parsing;
import m02racingcar.RandomNumberGenerator;
import m02racingcar.exception.ContainException;
import m02racingcar.exception.ParsingException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCarList {
    private final List<RacingCar> racingCarList;

    public RacingCarList() {
        racingCarList = new ArrayList<>();
        setRacingCarList();
    }

    private void setRacingCarList() {
        final String info = "경주하는 차는 몇 대입니까?";
        int setCount;
        try {
            setCount = Parsing.strToInteger(new CustomScanner(info).getFirstResponse()[0]);
        } catch (ParsingException e) {
            e.printMessage();
            setRacingCarList();
            return;
        }
        for (int i = 0; i < setCount; i++) {
            racingCarList.add(getRacingCar());
        }
    }

    private RacingCar getRacingCar() {
        final String info = (racingCarList.size()+1) + "번째 경주 차 이름을 입력하여 주세요";
        final String carName = new CustomScanner(info).getFirstResponse()[0];
        try {
            checkName(carName);
        } catch (ContainException e) {
            e.printMessage();
            return getRacingCar();
        }
        return new RacingCar(carName);
    }

    private void checkName(String carName) throws ContainException {
        if (isAlreadyExist(carName)) {
            throw new ContainException("이미 존재하는 이름입니다. 다시 입력해 주세요.");
        }
    }

    private boolean isAlreadyExist(String carName) {
        return racingCarList
                .stream()
                .filter(racingCar -> racingCar.isSameCarName(carName))
                .count() > 0;
    }

    public void step() {
        final int racingCarListSize = racingCarList.size();
        for (int i = 0; i < racingCarListSize; i++) {
            step(racingCarList.get(i));
        }
        print();
    }

    private void step(RacingCar racingCar) {
        if (isGoing()) {
            racingCar.go();
        }
    }

    private boolean isGoing() {
        final int start = 1;
        final int last = 10;
        return RandomNumberGenerator.generate(start, last) > 5;
    }

    public boolean haveOverPosition(int position) {
        return racingCarList
                .stream()
                .filter(racingCar -> racingCar.getPosition() >= position)
                .count() > 0;
    }

    public RacingCar getBestPosition() {
        return racingCarList
                .stream()
                .sorted(Comparator.comparing(RacingCar::getPosition).reversed())
                .findFirst()
                .orElseThrow(null);
    }

    public void print() {
        final int racingCarListSize = racingCarList.size();
        for (int i = 0; i < racingCarListSize; i++) {
            racingCarList.get(i).print();
        }
        System.out.println();
    }
}
