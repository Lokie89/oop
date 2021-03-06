package m06ladder.ladder;

import m06ladder.Location;
import m06ladder.person.Person;
import m06ladder.point.LadderPoint;

public class Ladder extends Location implements Bridge {
    public Ladder(LadderPoint pointY, LadderPoint pointX) {
        super(pointY, pointX);
    }

    @Override
    public void cross(Person person) {
        if (isOnBridgeLeft(person)) {
            person.goRight();
            person.goDown();
            return;
        }
        if (isOnBridgeRight(person)) {
            person.goLeft();
            person.goDown();
            return;
        }
    }

}

