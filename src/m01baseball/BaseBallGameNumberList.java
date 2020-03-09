package m01baseball;

import java.util.List;

public class BaseBallGameNumberList {

    private List<BaseBallGameNumber> baseBallGameNumberList;
    public static final int BASEBALL_NUMBER_SIZE = 3;

    public BaseBallGameNumberList() {

    }

    public BaseBallGameNumberList(List<BaseBallGameNumber> baseBallGameNumberList) {
        this.baseBallGameNumberList = baseBallGameNumberList;
    }

    protected void setBaseBallGameNumberList(List<BaseBallGameNumber> baseBallGameNumberList) {
        validateSize(baseBallGameNumberList);
        validateGameNumber(baseBallGameNumberList);
        this.baseBallGameNumberList = baseBallGameNumberList;
    }

    private void validateSize(List<BaseBallGameNumber> baseBallGameNumberList) {
        if (!isProfitSize(baseBallGameNumberList, BASEBALL_NUMBER_SIZE)) {
            throw new BaseBallGameNumberListException();
        }
    }

    private void validateGameNumber(List<BaseBallGameNumber> baseBallGameNumberList) {
        final int min = 0;
        final int max = 9;
        if (!isProfitGameNumber(baseBallGameNumberList, min, max)) {
            throw new BaseBallGameNumberException();
        }
    }


    private boolean isProfitSize(List<BaseBallGameNumber> baseBallGameNumberList, int size) {
        return baseBallGameNumberList.size() == size;
    }

    private boolean isProfitGameNumber(List<BaseBallGameNumber> baseBallGameNumberList, int min, int max) {
        return betweenMinAndMaxSize(baseBallGameNumberList, min, max) == BASEBALL_NUMBER_SIZE;
    }

    private long betweenMinAndMaxSize(List<BaseBallGameNumber> baseBallGameNumberList, int min, int max) {
        return baseBallGameNumberList
                .stream()
                .filter(baseBallGameNumber -> baseBallGameNumber.biggerThan(min) && baseBallGameNumber.lessThan(max))
                .count()
                ;
    }

    // 별로야
    public boolean[][] getContainSame(BaseBallGameNumberList baseBallGameAnswer) {
        final int baseBallGameNumberListSize = baseBallGameNumberList.size();
        boolean[][] containSame = new boolean[baseBallGameNumberListSize][2];
        for (int i = 0; i < baseBallGameNumberListSize; i++) {
            BaseBallGameNumber compareGameNumber = baseBallGameAnswer.baseBallGameNumberList.get(i);
            containSame[i][0] = isContainNumber(compareGameNumber);
            containSame[i][1] = isSameIndexNumber(compareGameNumber, i);
        }
        return containSame;
    }

    private boolean isContainNumber(BaseBallGameNumber compareGameNumber) {
        return baseBallGameNumberList
                .stream()
                .filter(baseBallGameNumber -> baseBallGameNumber.isSameNumber(compareGameNumber))
                .count() > 0;
    }

    private boolean isSameIndexNumber(BaseBallGameNumber compareGameNumber, int index) {
        return baseBallGameNumberList.get(index).isSameNumber(compareGameNumber);
    }

    public int getBaseballNumberSize() {
        return baseBallGameNumberList.size();
    }


}
