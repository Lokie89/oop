package m06ladder.ladder;

import m06ladder.person.Person;
import m06ladder.point.Point;

public class Ladder implements Bridge {
    Point pointY;
    Point pointX;

    @Override
    public void moveRight(Person person) {
        person.goRight();
    }

    @Override
    public void moveLeft(Person person) {
        person.goLeft();
    }

}

