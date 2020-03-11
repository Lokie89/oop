package m01baseball;

import m01baseball.exception.BaseBallGameException;
import m01baseball.exception.BaseBallGameNumberException;
import m01baseball.exception.BaseBallGameNumberListDupliException;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameQuestion extends BaseBallGameNumberList {

    public BaseBallGameQuestion() {
        setBaseBallQuestion();
    }

    private void setBaseBallQuestion() {
        try {
            setBaseBallGameNumberList(getRandomBaseBallGameNumberList());
        } catch (BaseBallGameNumberListDupliException
                | BaseBallGameNumberException e) {
            manageQuestionException(e);
        }
    }

    private void manageQuestionException(BaseBallGameException e) {
        setBaseBallQuestion();
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
}
