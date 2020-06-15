package m06ladder.location;

import m06ladder.UnderZeroLocationException;

public class LadderLocation implements Location {

    private int location;

    public LadderLocation(LadderLocation ladderLocation) {
        this.location = ladderLocation.location;
    }

    public LadderLocation(int location) {
        validateLocation(location);
        this.location = location;
    }

    private void validateLocation(int location) {
        if (isLocationOverZero(location)) {
            throw new UnderZeroLocationException();
        }
    }

    private boolean isLocationOverZero(int location) {
        return location > 0;
    }

    @Override
    public void increase() {
        location++;
    }

    @Override
    public void decrease() {
        location--;
    }

    @Override
    public void print() {
        System.out.println(location);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LadderLocation) {
            return ((LadderLocation) obj).location == this.location;
        }
        return super.equals(obj);
    }
}
