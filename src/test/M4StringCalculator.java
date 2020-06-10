package test;

import m04strcalculator.OperateContainer;
import m04strcalculator.Operator;

public class M4StringCalculator {
    public static void main(String[] args) {
        operateContainerTest();
    }

    private static void operateContainerTest() {
        OperateContainer operateContainer = new OperateContainer(1);
        operateContainer.operate(Operator.getOperator("+"), 2);
        Assert.assertTrue(operateContainer.getResult() == 3);
        operateContainer.operate(Operator.getOperator("/"), 3);
        Assert.assertTrue(operateContainer.getResult() == 1);
    }

    private static void operateString(){
        String question = "2 + 3 * 4 / 2";
        // split
        // validate
        // operate
    }
}
