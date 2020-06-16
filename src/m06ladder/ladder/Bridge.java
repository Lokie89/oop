package m06ladder.ladder;

import m06ladder.person.Person;

public interface Bridge {
    boolean isOnBridgeLeft(Person person);
    boolean isOnBridgeRight(Person person);

}
