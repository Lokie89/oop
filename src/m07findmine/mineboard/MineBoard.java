package m07findmine.mineboard;

import m07findmine.point.Point;

public interface MineBoard {
    void digPoint(Point x, Point y);
    void print();
}
