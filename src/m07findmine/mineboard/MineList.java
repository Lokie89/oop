package m07findmine.mineboard;

import m07findmine.mine.Bomb;
import m07findmine.mine.Mine;
import m07findmine.point.Point;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class MineList implements MineBoard {
    private Mine[][] mineArray;

    public MineList(int mineBoardSize, int bombPercentage) {
        mineArray = new Mine[mineBoardSize][mineBoardSize];
        setMineArray(bombPercentage);
    }

    public MineList(Mine[][] mineArray) {
        this.mineArray = mineArray;
    }

    @Override
    public void print() {
        for (Mine[] mines : mineArray) {
            printRows(mines);
            System.out.println();
        }
    }

    private void setMineArray(final int bombPercentage) {
        for (Mine[] mines : mineArray) {
            setMineRows(mines, bombPercentage);
        }
    }

    private void setMineRows(Mine[] mines, final int bombPercentage) {
        final int minesLength = mines.length;
        for (int i = 0; i < minesLength; i++) {
            mines[i] = getRandomBomb(bombPercentage);
        }
    }

    private Bomb getRandomBomb(int percentage) {
        boolean isExplosive = false;
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        if (randomNumber < percentage) {
            isExplosive = true;
        }
        return new Bomb(isExplosive);
    }

    private void printRows(Mine[] mines) {
        Arrays.asList(mines)
                .stream()
                .forEach(mine -> mine.print());
    }

    @Override
    public void digPoint(Point x, Point y) {
        final int indexX = x.getPoint() - 1;
        final int indexY = y.getPoint() - 1;
        mineArray[indexX][indexY].findBomb();
    }
}
