package m04strcalculator;

public class OperateContainer {

    private double result;

    public OperateContainer(double number) {
        this.result = number;
    }

    public void operate(Operator operator, double number2) {
        this.result = operator.calculate(this.result, number2);
    }

    public double getResult() {
        return result;
    }

}