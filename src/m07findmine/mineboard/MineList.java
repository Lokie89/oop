package m07findmine.mineboard;

import m07findmine.FindAllMineException;
import m07findmine.mine.Mine;
import m07findmine.mine.RandomBomb;
import m07findmine.point.Point;

import java.util.Arrays;

public class MineList implements MineBoard {
    private Mine[][] mineArray;
    private int bombsCount;
    private int dugPointsCount;

    public MineList(int mineBoardSize, int bombPercentage) {
        mineArray = new Mine[mineBoardSize][mineBoardSize];
        setMineArray(bombPercentage);
        setBombsCount();
        System.out.println("폭탄 " + bombsCount + "개");
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
            mines[i] = new RandomBomb(bombPercentage);
        }
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
        setDugPointsCount();
        checkFoundMine();
    }

    private void checkFoundMine() {
        if (isEqualBombCountAndNotDugPointCount()) {
            throw new FindAllMineException();
        }
    }

    private boolean isEqualBombCountAndNotDugPointCount() {
        final int columnsLength = this.mineArray.length;
        final int rowsLength = this.mineArray[0].length;
        return bombsCount == (columnsLength * rowsLength - dugPointsCount);
    }

    private void setBombsCount() {
        for (Mine[] mines : mineArray) {
            setBombCount(mines);
        }
    }

    private void setBombCount(Mine[] mines) {
        this.bombsCount = (int) Arrays.asList(mines)
                .stream()
                .filter(Mine::isBomb)
                .count()
        ;
    }

    private void setDugPointsCount() {
        for (Mine[] mines : mineArray) {
            setDugPointsCount(mines);
        }
    }

    private void setDugPointsCount(Mine[] mines) {
        this.dugPointsCount = (int) Arrays.asList(mines)
                .stream()
                .filter(Mine::isFound)
                .count()
        ;
    }


}
