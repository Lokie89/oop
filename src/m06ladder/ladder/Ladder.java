package m06ladder.ladder;

import m06ladder.person.Person;
import m06ladder.point.LadderPoint;

public class Ladder implements Bridge {
    private LadderPoint pointY;
    private LadderPoint pointX;

    public Ladder(LadderPoint pointY, LadderPoint pointX) {
        this.pointY = pointY;
        this.pointX = pointX;
    }

    @Override
    public boolean isOnBridgeLeft(Person person) {
        return false;
    }

    @Override
    public boolean isOnBridgeRight(Person person) {
        return false;
    }


}

