package m1baseball;

public class Parsing {

    public static Integer[] strToInteger(String[] strArr) throws Exception{
        int strArrSize = strArr.length;
        Integer[] integers = new Integer[strArrSize];
        for (int i = 0; i < strArrSize; i++) {
            integers[i] = strToInteger(strArr[i]);
        }
        return integers;
    }

    public static Integer strToInteger(String str) throws Exception{
        return Integer.parseInt(str);
    }
}
