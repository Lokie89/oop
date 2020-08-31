package baseball;

import baseball.generator.Generatable;

public class BaseBallNumber {
    private final int baseBallNumber;
    private final int min = 0;
    private final int max = 9;

    public BaseBallNumber(Generatable<Integer> generatable) {
        final Integer generatedNumber = generatable.getGenerated();
        validateBaseBallNumber(generatedNumber);
        baseBallNumber = generatedNumber;
    }

    public BaseBallNumber(int baseBallNumber) {
        validateBaseBallNumber(baseBallNumber);
        this.baseBallNumber = baseBallNumber;
    }

    private void validateBaseBallNumber(Integer number) {
        if (!isBoundedBaseBallNumber(number)) {
            throw new UnboundedBaseBallNumberException();
        }
    }

    private boolean isBoundedBaseBallNumber(Integer number) {
        return number != null && min <= number && number <= max;
    }

    // Set 으로 데이터 정의하기 위해 equals, hashCode 재정의
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseBallNumber)) {
            return false;
        }
        BaseBallNumber baseBallNumber = (BaseBallNumber) obj;
        return baseBallNumber.baseBallNumber == this.baseBallNumber;
    }

    // hashCode 재정의 다시?--
    @Override
    public int hashCode() {
        return baseBallNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(baseBallNumber);
    }
}
