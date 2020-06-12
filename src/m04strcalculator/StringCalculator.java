package m04strcalculator;

public class StringCalculator implements Calculator {

    String[] calculateStrArr;

    StringOperatorContainer stringOperateContainer;

    public StringCalculator(String calculateStr, String splitStr) {
        splitString(calculateStr, splitStr);
        validateCalculateStr();
    }

    private void validateCalculateStr() {
        if (!isOddNumber(calculateStrArr.length)) {
            throw new UnavailableCalculateException();
        }
    }

    private void splitString(String calculateStr, String splitStr) {
        calculateStrArr = calculateStr.split(splitStr);
    }

    @Override
    public void calculate() {
        stringOperateContainer = new StringOperatorContainer(calculateStrArr[0]);
        for (int i = 1; i < calculateStrArr.length; i += 2) {
            stringOperateContainer.operate(calculateStrArr[i], calculateStrArr[i + 1]);
        }
        stringOperateContainer.printResult();
    }

    private boolean isOddNumber(int number) {
        return number % 2 == 1;
    }
}
