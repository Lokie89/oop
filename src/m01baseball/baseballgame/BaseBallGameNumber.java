package m01baseball.baseballgame;

import m01baseball.exception.BaseBallGameNumberException;

public class BaseBallGameNumber {

    private final int baseballGameNumber;

    public BaseBallGameNumber(int baseballGameNumber) {
        validateBaseBallNumber(baseballGameNumber);
        this.baseballGameNumber = baseballGameNumber;
    }

    private void validateBaseBallNumber(int baseBallNumber) {
        if (!isProfitBaseBallNumber(baseBallNumber)) {
            throw new BaseBallGameNumberException();
        }
    }

    private boolean isProfitBaseBallNumber(int baseBallNumber) {
        final int min = 0;
        final int max = 9;
        return biggerThan(baseBallNumber, min) && lessThan(baseBallNumber, max);
    }

    private boolean biggerThan(int compareNumber1, int compareNumber2) {
        return compareNumber1 >= compareNumber2;
    }

    private boolean lessThan(int compareNumber1, int compareNumber2) {
        return compareNumber1 <= compareNumber2;
    }

    public boolean biggerThan(int compareNumber) {
        return baseballGameNumber >= compareNumber;
    }

    public boolean lessThan(int compareNumber) {
        return baseballGameNumber <= compareNumber;
    }

    public boolean isSameNumber(BaseBallGameNumber baseballGameNumber) {
        return this.baseballGameNumber == baseballGameNumber.baseballGameNumber;
    }

}
