package m03lotto.lotto;

import m03lotto.CustomScanner;
import m03lotto.Parsing;
import m03lotto.ParsingException;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private QuizNumberList quiz;
    private List<BettingNumberList> bettingList;

    public Lotto() {
        quiz = new QuizNumberList();
        setBettingList();
        printLotto();
    }

    private void setBettingList() {
        bettingList = new ArrayList<>();
        final int money = getMoney();
        final int bettingCount = money / 1000;
        for (int i = 0; i < bettingCount; i++) {
            System.out.println((i+1)+"번째 장 로또");
            bettingList.add(getBetting());
        }
    }

    private int getMoney() {
        final String info = "베팅하실 금액 ?";
        String response = new CustomScanner(info).getFirstResponse()[0];
        Integer money;
        try {
            money = Parsing.strToInteger(response);
        } catch (ParsingException e) {
            e.printMessage();
            return getMoney();
        }
        return money;
    }

    private BettingNumberList getBetting() {
        return new BettingNumberList();
    }

    private void printLotto() {
        quiz.printLottoNumber();
        quiz.printBonusNumber();
        quiz.printResult(bettingList);
    }
}
