package m01baseball;

import m01baseball.exception.*;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private final BaseBallGameNumberList baseBallGameQuestion;
    private int pitchableCount = 10;
    private BaseBallGamePlayer baseBallGamePlayer;

    public BaseBallGame(BaseBallGameNumberList baseBallGameQuestion) {
        this.baseBallGameQuestion = baseBallGameQuestion;
        setBaseBallGamePlayer();
    }

    public BaseBallGame() {
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
        return baseBallGameRuleList.getStrikeCount() != baseBallGameQuestion.size();
    }

    private void printPitchableCount(){
        System.out.println(pitchableCount+" / 10");
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
