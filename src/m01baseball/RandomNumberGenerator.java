package m01baseball;

import m01baseball.exception.RandomNumberGeneratorException;

import java.util.Random;

public class RandomNumberGenerator {
    private int start;
    private int end;

    public RandomNumberGenerator(int start, int end) {
        validateStartLessThanEnd(start, end);
        this.start = start;
        this.end = end;
    }

    private void validateStartLessThanEnd(int start, int end) {
        if (!isStartLessThanEnd(start, end)) {
            throw new RandomNumberGeneratorException();
        }
    }

    private boolean isStartLessThanEnd(int start, int end) {
        return start < end;
    }

    public int getRandomNumber() {
        return new Random().nextInt((end - start + 1)) + start;
    }
}
