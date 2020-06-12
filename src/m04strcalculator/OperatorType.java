package m04strcalculator;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 + number2;
        }
    },
    SUBTRACT("-") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 * number2;
        }
    },
    DIVISION("/") {
        @Override
        public double calculate(double number1, double number2) {
            return number1 / number2;
        }
    },
    ;

    private String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public abstract double calculate(double number1, double number2);

    public static OperatorType getOperator(String symbol){
        return Arrays.asList(OperatorType.values())
                .stream()
                .filter(operatorType -> operatorType.symbol.equals(symbol))
                .findFirst()
                .get()
                ;
    }
}
