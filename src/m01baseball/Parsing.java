package m01baseball;

import m01baseball.exception.ParsingException;

public class Parsing {
    public static Integer strToInteger(String str) throws ParsingException {
        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new ParsingException();
        }
    }
    public static String intToString(Integer integer) throws ParsingException{
        return String.valueOf(integer);
    }
}
