package m06ladder.ladder;

import m06ladder.Location;
import m06ladder.person.Person;
import m06ladder.point.Point;

public class Ladder extends Location implements Bridge {

    public Ladder(Point pointY, Point pointX) {
        super(pointY, pointX);
    }

    @Override
    public void moveRight(Person person) {
        person.goRight();
    }

    @Override
    public void moveLeft(Person person) {
        person.goLeft();
    }

}

