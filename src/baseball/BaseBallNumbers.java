package baseball;

import baseball.generator.Generatable;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseBallNumbers {
    // 순서 보장
    private final Set<BaseBallNumber> baseBallNumbers = new LinkedHashSet<>();

    public BaseBallNumbers(Generatable<Integer> generator, int size) {
        generateBaseBallNumber(generator, size);
    }

    private void generateBaseBallNumber(Generatable<Integer> generator, int size) {
        validateFillableBound(generator, size);
        while (!isFullBaseBallNumbers(size)) {
            baseBallNumbers.add(getBaseBallNumber(generator));
        }
    }

    private void validateFillableBound(Generatable<Integer> generator, int size) {
        if (!isFillableBound(generator, size)) {
            throw new IllegalBaseBallNumbersSizeException();
        }
    }

    private boolean isFillableBound(Generatable<Integer> generator, int size) {
        return generator.getBound() >= size;
    }

    private boolean isFullBaseBallNumbers(int size) {
        return baseBallNumbers.size() == size;
    }

    private BaseBallNumber getBaseBallNumber(Generatable<Integer> generator) {
        try {
            return new BaseBallNumber(generator);
        } catch (UnboundedBaseBallNumberException e) {
            return getBaseBallNumber(generator);
        }
    }

    @Override
    public String toString() {
        return baseBallNumbers.toString();
    }
}
