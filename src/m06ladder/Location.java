package m06ladder;

import m06ladder.point.LadderPoint;

public class Location {
    protected LadderPoint pointY;
    protected LadderPoint pointX;

    public Location(LadderPoint pointY, LadderPoint pointX) {
        this.pointY = pointY;
        this.pointX = pointX;
    }

    // Y 포인트와, X 포인트가 같을 때
    protected boolean isOnBridgeLeft(Location personLocation) {
        return pointY.equals(personLocation.pointY) && pointX.equals(personLocation.pointX);
    }

    // Y 포인트는 같고, X 포인트가 하나 적은 것
    protected boolean isOnBridgeRight(Location personLocation) {
        pointX.increase();
        final boolean isOnBridgeRight = isOnBridgeLeft(personLocation);
        pointX.decrease();
        return isOnBridgeRight;
    }
}
