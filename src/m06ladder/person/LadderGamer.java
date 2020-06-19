package m06ladder.person;

import m06ladder.Location;
import m06ladder.point.LadderPoint;

public class LadderGamer extends Location implements Person {

    public LadderGamer(LadderPoint pointX) {
        super(new LadderPoint(1), pointX);
    }

    @Override
    public void goUp() {
        pointY.decrease();
    }

    @Override
    public void goDown() {
        pointY.increase();
    }

    @Override
    public void goLeft() {
        pointX.decrease();
    }

    @Override
    public void goRight() {
        pointX.increase();
    }

    @Override
    public void printX() {
        pointX.print();
    }

    public boolean isFinish(LadderPoint finishPoint) {
        return pointY.isBigger(finishPoint);
    }

}
