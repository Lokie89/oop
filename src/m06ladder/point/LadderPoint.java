package m06ladder.point;

public class LadderPoint implements Point {

    private int ladderPoint;

    public LadderPoint(int ladderPoint) {
        this.ladderPoint = ladderPoint;
    }
    @Override
    public void print() {
        System.out.print(ladderPoint);
    }

    @Override
    public void increase() {
        ladderPoint++;
    }

    @Override
    public void decrease() {
        ladderPoint--;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LadderPoint) {
            return ladderPoint == ((LadderPoint) obj).ladderPoint;
        }
        return super.equals(obj);
    }

}
