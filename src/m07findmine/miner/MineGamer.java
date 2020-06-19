package m07findmine.miner;

import m07findmine.mineboard.MineBoard;
import m07findmine.point.MinePoint;
import m07findmine.point.Point;

public class MineGamer implements Miner {
    private Point x;
    private Point y;

    public MineGamer(int x, int y){
        this.x = new MinePoint(x);
        this.y = new MinePoint(y);
    }

    @Override
    public void dig(MineBoard mineBoard) {
        mineBoard.digPoint(x, y);
    }
}
