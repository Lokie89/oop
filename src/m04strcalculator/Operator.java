package m04strcalculator;

import java.util.Arrays;

public enum Operator {
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

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract double calculate(double number1, double number2);

    public static Operator getOperator(String symbol){
        return Arrays.asList(Operator.values())
                .stream()
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .get()
                ;
    }
}
