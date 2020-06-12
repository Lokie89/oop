package test;

import m04strcalculator.*;

public class M4StringCalculator {
    public static void main(String[] args) {
        try {
            operateStringTest();
        } catch (UnavailableCalculateException e) {

        } catch (NumberParsingException e) {

        } catch (OperateException e) {

        }
    }

    private static void operateStringTest() {
        String question = "2 * 3 * 4 / 2";
        String splitStr = " ";
        // split
        // validate
        // operate
        Calculator stringCalculator = new StringCalculator(question, splitStr);
        stringCalculator.calculate();
    }
}
