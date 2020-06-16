package m06ladder;

import m06ladder.point.Point;

public class Location {
    protected Point pointY;
    protected Point pointX;

    public Location() {
    }

    public Location(Point pointY, Point pointX) {
        this.pointY = pointY;
        this.pointX = pointX;
    }

    protected boolean isLeftLocation(Location location) {
        location.pointX.decrease();
        Location rightLocation = new Location(location.pointY, location.pointX);
        final boolean isLeftLocation = isSameLocation(rightLocation);
        location.pointX.increase();
        return isLeftLocation;
    }

    protected boolean isSameLocation(Location location) {
        return pointY.equals(location.pointY) && pointX.equals(location.pointX);
    }

}
