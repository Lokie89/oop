package m07findmine.point;

import m07findmine.MinePointNegativeException;

public class MinePoint implements Point {
    private int point;

    public MinePoint() {
//        validatePoint();
    }

    public MinePoint(int point) {
        validatePoint(point);
        this.point = point;
    }

    private void validatePoint(int point) {
        if (!isPositiveNumber(point)) {
            throw new MinePointNegativeException();
        }
    }

    private boolean isPositiveNumber(int point) {
        return point >= 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MinePoint) {
            return this.point == ((MinePoint) obj).point;
        }
        return super.equals(obj);
    }

    // 삭제 할 수 있는 방법?
    @Override
    public int getPoint(){
        return point;
    }
}
