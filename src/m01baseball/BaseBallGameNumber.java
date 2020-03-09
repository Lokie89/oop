package m01baseball;

public class BaseBallGameNumber extends GameNumber {

    public BaseBallGameNumber(int baseBallNumber) {
        super(baseBallNumber);
        validateBaseBallNumber(baseBallNumber);
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

}
