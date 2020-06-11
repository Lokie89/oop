package m04strcalculator;

import java.util.NoSuchElementException;

public class StringOperateContainer implements Operate<String> {

    private double result;

    public StringOperateContainer(String numberStr) {
        this.result = validateAvailableOperate(numberStr);
    }

    @Override
    public void operate(String operatorStr, String numberStr) {
        try {
            this.result = Operator.getOperator(operatorStr)
                    .calculate(this.result, validateAvailableOperate(numberStr));
        } catch (NoSuchElementException e) {
            throw new UnavailableCalculateException();
        }
    }

    private double validateAvailableOperate(String numberStr) {
        try {
            return Double.parseDouble(numberStr);
        } catch (NumberFormatException e) {
            throw new NumberParsingException();
        }
    }

    public void printResult(){
        System.out.println(result);
    }

}