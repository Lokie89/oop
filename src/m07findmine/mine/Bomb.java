package m07findmine.mine;

import m07findmine.MineExploreException;

public class Bomb implements Mine {
    private boolean isExplosive;
    private boolean isFound;

    public Bomb(boolean isExplosive) {
        this.isExplosive = isExplosive;
        isFound = false;
    }

    @Override
    public void findBomb() {
        isFound = true;
        explore();
    }

    private void explore() {
        if (isExplosive && isFound) {
            throw new MineExploreException();
        }
    }

    @Override
    public void print() {
        if(isFound){
            System.out.print(isExplosive+" ");
            return;
        }
        System.out.print("Closed ");
    }
}
