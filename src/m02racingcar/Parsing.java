package m02racingcar;

import m02racingcar.exception.ParsingException;

public class Parsing {
    public static Integer strToInteger(String str) {
        Integer integer;
        try {
            integer = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new ParsingException();
        }
        return integer;
    }
}
