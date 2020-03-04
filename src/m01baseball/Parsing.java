package m01baseball;

import m01baseball.exception.ParsingException;

public class Parsing {

    public static Integer[] strToInteger(String[] strArr) throws ParsingException {
        int strArrSize = strArr.length;
        Integer[] integers = new Integer[strArrSize];
        for (int i = 0; i < strArrSize; i++) {
            integers[i] = strToInteger(strArr[i]);
        }
        return integers;
    }

    public static Integer strToInteger(String str) {
        Integer integer;
        try {
            integer = Integer.parseInt(str);
        } catch (RuntimeException e) {
            throw new ParsingException();
        }
        return integer;
    }
}
