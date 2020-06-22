package m07findmine.mine;

import m07findmine.MineExplodeException;

public class Bomb implements Mine {
    private boolean isBomb;
    private boolean isFound;

    public Bomb() {
    }

    public Bomb(boolean isBomb) {
        this.isBomb = isBomb;
        isFound = false;
    }

    protected void setBomb(boolean isExplosive) {
        this.isBomb = isExplosive;
    }


    @Override
    public void findBomb() {
        isFound = true;
        explode();
    }

    private void explode() {
        if (isBomb && isFound) {
            throw new MineExplodeException();
        }
    }

    @Override
    public void print() {
        if (isFound) {
            System.out.print("■");
            return;
        }
        System.out.print("□");
    }

    @Override
    public boolean isBomb(){
        return isBomb;
    }

    @Override
    public boolean isFound() {
        return isFound;
    }
}
