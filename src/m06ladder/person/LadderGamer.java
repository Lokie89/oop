package m06ladder.person;

import m06ladder.point.LadderPoint;
import m06ladder.point.Point;

public class LadderGamer implements Person {
    private LadderPoint pointY;
    private LadderPoint pointX;


    public LadderGamer(LadderPoint pointX) {
        this.pointY = new LadderPoint(1);
        this.pointX = pointX;
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
    public void print() {
        pointX.print();
    }

    public boolean isFinish(Point finishPoint) {
        return pointY.equals(finishPoint);
    }

}
