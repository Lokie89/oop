package m1baseball.game;

import java.util.LinkedHashSet;
import java.util.Set;

public class RandomNumberList extends NumberList {
    private final Set<Integer> randomNumberList;

    public RandomNumberList(int start, int last, int size) {
        randomNumberList = new LinkedHashSet<>();
        setRandomNumberList(start, last, size);
        setNumberList(randomNumberList);
        System.out.println(randomNumberList);
    }

    private void setRandomNumberList(int start, int last, int size) {
        while (!isProfitSize(size)) {
            randomNumberList.add(getRandomNumber(start, last));
        }
    }

    private boolean isProfitSize(int size) {
        return size == randomNumberList.size();
    }

    private int getRandomNumber(int start, int last) {
        return RandomNumberGenerator.generate(start, last);
    }

}
