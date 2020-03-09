package m01baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameQuestion {

    private final List<BaseBallGameNumber> baseBallGameNumberList;

    public BaseBallGameQuestion() {
        List<BaseBallGameNumber> baseBallGameNumberList = getRandomBaseBallGameNumberList();
        validateSize(baseBallGameNumberList);
        validateGameNumber(baseBallGameNumberList);
        this.baseBallGameNumberList = baseBallGameNumberList;
    }

    private List<BaseBallGameNumber> getRandomBaseBallGameNumberList() {
        List<BaseBallGameNumber> baseBallGameNumberList = new ArrayList<>();
        final int randomBaseBallGameNumberListSize = BaseBallGameNumberList.BASEBALL_NUMBER_SIZE;
        for (int i = 0; i < randomBaseBallGameNumberListSize; i++) {
            baseBallGameNumberList.add(getBaseBallGameNumber());
        }
        return baseBallGameNumberList;
    }

    private BaseBallGameNumber getBaseBallGameNumber() {
        return new BaseBallGameNumber(getRandomNumber());
    }

    private int getRandomNumber() {
        final int minNumber = 0;
        final int maxNumber = 9;
        return new RandomNumberGenerator(minNumber, maxNumber).getRandomNumber();
    }

    public boolean isContainBaseBallGameNumber(BaseBallGameNumber baseBallGameNumber){
        baseballgame
    }

}
