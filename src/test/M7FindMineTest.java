package test;

import m07findmine.mine.Bomb;
import m07findmine.mine.Mine;

public class M7FindMineTest {
    public static void main(String[] args) {
        Mine mine = new Bomb(true);
        mine.findBomb();
    }
}
