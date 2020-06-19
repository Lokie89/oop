package m06ladder;

import m06ladder.person.Person;
import m06ladder.point.LadderPoint;

public class Location implements Comparable<Location> {
    protected LadderPoint pointY;
    protected LadderPoint pointX;

    public Location(LadderPoint pointY, LadderPoint pointX) {
        this.pointY = pointY;
        this.pointX = pointX;
    }

    // Y 포인트와, X 포인트가 같을 때
    protected boolean isOnBridgeLeft(Person person) {
        return equals(person);
    }

    // Y 포인트는 같고, X 포인트가 하나 적은 것
    protected boolean isOnBridgeRight(Person person) {
        pointX.increase();
        final boolean isOnBridgeRight = isOnBridgeLeft(person);
        pointX.decrease();
        return isOnBridgeRight;
    }

    @Override
    public int compareTo(Location compareLocation) {
        if (this.pointY.isBigger(compareLocation.pointY)) {
            return 1;
        }
        if (compareLocation.pointY.isBigger(this.pointY)) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Location){
            Location compareLocation = (Location)obj;
            return pointY.equals(compareLocation.pointY) && pointX.equals(compareLocation.pointX);
        }
        return super.equals(obj);
    }
}
