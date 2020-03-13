package m01baseball.baseballgame;

import m01baseball.ScanResponse;
import m01baseball.exception.*;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private final BaseBallGameNumberList baseBallGameQuestion;
    private final int pitchableLimit = 10;
    private int pitchableCount;
    private BaseBallGamePlayer baseBallGamePlayer;

    public BaseBallGame(BaseBallGameNumberList baseBallGameQuestion, int pitchableCount) {
        this.baseBallGameQuestion = baseBallGameQuestion;
        this.pitchableCount = pitchableCount;
        setBaseBallGamePlayer();
    }

    public BaseBallGame(int pitchableCount) {
        this.pitchableCount = pitchableCount;
        baseBallGameQuestion = new BaseBallGameQuestion();
        setBaseBallGamePlayer();

    }

    public BaseBallGame() {
        pitchableCount = pitchableLimit;
        baseBallGameQuestion = new BaseBallGameQuestion();
        setBaseBallGamePlayer();
    }


    public void play() {
        try {
            while (isPitchable() && pitchAndResult()) {
                decreasePitch();
            }
        } catch (ParsingException
                | BaseBallGameNumberListDupliException
                | RandomNumberGeneratorException
                | BaseBallGameNumberException
                | BaseBallGameNumberListSizeException e) {
            managePlayException(e);
            return;
        }
        end();
    }

    private void managePlayException(BaseBallGameException e) {
        e.print();
        play();
    }


    private void setBaseBallGamePlayer() {
        final String info = "이름을 입력하세요";
        baseBallGamePlayer = new BaseBallGamePlayer(ScanResponse.getResponse(info));
    }

    private boolean pitchAndResult() {
        printPitchableCount();
        baseBallGamePlayer.print();
        BaseBallGameRuleList baseBallGameRuleList = new BaseBallGameRuleList(confirmRule(getAnswer()));
        baseBallGameRuleList.print();
        return baseBallGameRuleList.isAllStrike();
    }

    private void printPitchableCount() {
        System.out.println(pitchableCount + " / " + pitchableLimit);
    }

    private BaseBallGameNumberList getAnswer() {
        return baseBallGamePlayer.getBaseBallGameNumberList();
    }

    private void end() {
        System.out.println("게임 종료");
    }

    private boolean isPitchable() {
        return pitchableCount > 0;
    }

    private void decreasePitch() {
        pitchableCount--;
    }

    private List<BaseBallGameRule> confirmRule(BaseBallGameNumberList baseBallGameNumberList) {
        List<BaseBallGameRule> baseBallGameRuleList = new ArrayList<>();
        boolean[][] containSames = baseBallGameQuestion.getContainSame(baseBallGameNumberList);
        for (boolean[] containSame : containSames) {
            boolean isContain = containSame[0];
            boolean isSame = containSame[1];
            baseBallGameRuleList.add(BaseBallGameRule.getBaseBallGameResult(isContain, isSame));
        }
        return baseBallGameRuleList;
    }


}
