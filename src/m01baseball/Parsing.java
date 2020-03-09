package m01baseball;

public class Parsing {
    public static Integer strToInteger(String str) throws ParsingException{
        return Integer.parseInt(str);
    }
    public static String intToString(Integer integer) throws ParsingException{
        return String.valueOf(integer);
    }
}
