package m01baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private final BaseBallGameQuestion baseBallGameQuestion;
    private int pitchableCount = 10;
    private BaseBallGamePlayer baseBallGamePlayer;

    public BaseBallGame(BaseBallGameQuestion baseBallGameQuestion) {
        this.baseBallGameQuestion = baseBallGameQuestion;
    }

    public BaseBallGame() {
        baseBallGameQuestion = new BaseBallGameQuestion();
    }


    public void play() {
        baseBallGamePlayer = new BaseBallGamePlayer("이름");
        while (isPitchable() && pitchAndResult()) {
            decreasePitch();
        }
        end();
    }

    private boolean pitchAndResult() {
        baseBallGamePlayer.print();
        BaseBallGameRuleList baseBallGameRuleList = new BaseBallGameRuleList(confirmRule(getAnswer()));
        baseBallGameRuleList.print();
        return baseBallGameRuleList.getStrikeCount() == baseBallGameQuestion.getBaseballNumberSize();
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
        boolean[][] containSames = baseBallGameNumberList.getContainSame(baseBallGameNumberList);
        for (boolean[] containSame : containSames) {
            boolean isContain = containSame[0];
            boolean isSame = containSame[1];
            baseBallGameRuleList.add(BaseBallGameRule.getBaseBallGameResult(isContain, isSame));
        }
        return baseBallGameRuleList;
    }


}
