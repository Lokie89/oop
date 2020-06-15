package m06ladder;

import m06ladder.location.LadderLocation;

public class Ladder {
    private LadderLocation y; // 높이
    private LadderLocation x; // 세로줄 번호

    public Ladder(LadderLocation y, LadderLocation x) {
        this.y = y;
        this.x = x;
    }

    public Ladder(int y, int x) {
        this.y = new LadderLocation(y);
        this.x = new LadderLocation(x);
    }

    public boolean isBesideLadder(Ladder ladder) {
        if (!isSameY(ladder)) {
            return false;
        }
        LadderLocation testX1 = new LadderLocation(x);
        LadderLocation testX2 = new LadderLocation(x);
        testX1.decrease();
        testX2.increase();
        return this.x.equals(testX1) || this.x.equals(testX2);
    }

    private boolean isSameY(Ladder ladder) {
        return this.y.equals(ladder.y);
    }
}
