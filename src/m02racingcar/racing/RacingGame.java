package m02racingcar.racing;

import m02racingcar.CustomScanner;
import m02racingcar.Parsing;
import m02racingcar.exception.ParsingException;

public class RacingGame {
    private RacingCarList racingCarList;
    private final int goal;

    public RacingGame() {
        racingCarList = new RacingCarList();
        this.goal = getGoal();
    }

    private int getGoal() {
        final String info = "결승선을 정해주세요.";
        int goal;
        try {
            goal = Parsing.strToInteger(new CustomScanner(info).getFirstResponse()[0]);
        } catch (ParsingException e) {
            e.printMessage();
            return getGoal();
        }
        return goal;
    }

    public void play() {
        while (!isHavingWinner()) {
            racingCarList.step();
        }
        printWinner();
    }

    private void printWinner(){
        final RacingCar winner = racingCarList.getBestPosition();
        System.out.println("우승자는 : ");
        winner.print();
    }

    private boolean isHavingWinner() {
        return racingCarList.haveOverPosition(goal);
    }


}
