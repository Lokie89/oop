package m06ladder.person;

import m06ladder.point.Point;

public class LadderGamer implements Person {
    Point pointY;
    Point pointX;

    @Override
    public void goUp() {
        pointY.increase();
    }

    @Override
    public void goDown() {
        pointY.decrease();
    }

    @Override
    public void goLeft() {
        pointX.decrease();
    }

    @Override
    public void goRight() {
        pointX.increase();
    }
}
