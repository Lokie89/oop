package m03lotto.lotto;

import java.util.ArrayList;
import java.util.List;

public class QuizNumberList extends LottoNumberList {
    private final LottoNumber bonusNumber;

    public QuizNumberList() {
        super(new ArrayList<>());
        setLottoNumberList();
        bonusNumber = getQuizLottoNumber();
    }

    private LottoNumber getQuizLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        try {
            validateContainLottoNumber(lottoNumber);
        } catch (LottoException e) {
            return getQuizLottoNumber();
        }
        return lottoNumber;
    }

    private void setLottoNumber() {
        addLottoNumber(getQuizLottoNumber());
    }

    private void setLottoNumberList() {
        while (isLottoUnderSize()) {
            setLottoNumber();
        }
    }

    public void printBonusNumber() {
        System.out.print("bonus : ");
        bonusNumber.print();
        System.out.println();
    }

    private boolean isContainBonus(LottoNumberList lottoNumberList) {
        return lottoNumberList.isContainLottoNumber(bonusNumber);
    }

    private void printResult(long containCount, boolean isContainBonus) {
        LottoGrade.howGrade((int) containCount, isContainBonus).print();
    }

    public void printResult(List<BettingNumberList> bettingList) {
        for (LottoNumberList betting : bettingList) {
            long containCount = getContainCount(betting);
            betting.printLottoNumber();
            printResult(containCount, isContainBonus(betting));
        }
    }

}
