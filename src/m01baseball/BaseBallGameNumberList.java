package m01baseball;

import java.util.List;

public class BaseBallGameNumberList {

    public static final int BASEBALL_NUMBER_SIZE = 3;

    public static void validateSize(List<BaseBallGameNumber> baseBallGameNumberList) {
        if (isProfitSize(baseBallGameNumberList, BASEBALL_NUMBER_SIZE)) {
            throw new BaseBallGameNumberListException();
        }
    }

    protected static void validateGameNumber(List<BaseBallGameNumber> baseBallGameNumberList) {
        final int min = 0;
        final int max = 9;
        if (isProfitGameNumber(baseBallGameNumberList, min, max)) {
            throw new BaseBallGameNumberException();
        }
    }



    private static boolean isProfitSize(List<BaseBallGameNumber> baseBallGameNumberList, int size) {
        return baseBallGameNumberList.size() == size;
    }

    private static boolean isProfitGameNumber(List<BaseBallGameNumber> baseBallGameNumberList, int min, int max) {
        return betweenMinAndMaxSize(baseBallGameNumberList, min, max) == BASEBALL_NUMBER_SIZE;
    }

    private static long betweenMinAndMaxSize(List<BaseBallGameNumber> baseBallGameNumberList, int min, int max) {
        return baseBallGameNumberList
                .stream()
                .filter(baseBallGameNumber -> baseBallGameNumber.biggerThan(min) && baseBallGameNumber.lessThan(max))
                .count()
                ;
    }


}
