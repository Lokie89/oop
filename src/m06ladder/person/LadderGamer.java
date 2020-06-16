package m06ladder.person;

import m06ladder.Location;
import m06ladder.point.LadderPoint;
import m06ladder.point.Point;

public class LadderGamer extends Location implements Person {

    public LadderGamer(Point pointX) {
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

    public boolean isFinish(Point finishPoint) {
        return pointY.equals(finishPoint);
    }

}
