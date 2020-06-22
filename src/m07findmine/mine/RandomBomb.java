package m07findmine.mine;

import java.util.Random;

public class RandomBomb extends Bomb {

    public RandomBomb(final int bombPercentage) {
        boolean isBomb = false;
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        if (randomNumber < bombPercentage) {
            isBomb = true;
        }
        setBomb(isBomb);
    }
}
