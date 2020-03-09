package m01baseball;

import java.util.List;

public class BaseBallGameRuleList {
    private final List<BaseBallGameRule> baseBallGameRuleList;

    public BaseBallGameRuleList(List<BaseBallGameRule> baseBallGameRuleList) {
        this.baseBallGameRuleList = baseBallGameRuleList;
    }

    private long getResultCount(BaseBallGameRule rule) {
        return baseBallGameRuleList
                .stream()
                .filter(baseBallGameRule -> baseBallGameRule.equals(rule))
                .count()
                ;
    }

    public long getStrikeCount() {
        return getResultCount(BaseBallGameRule.STRIKE);
    }

    public long getBallCount() {
        return getResultCount(BaseBallGameRule.BALL);
    }

    public long getOutCount() {
        return getResultCount(BaseBallGameRule.OUT);
    }

    public void print() {
        System.out.print(getStrikeCount() + BaseBallGameRule.STRIKE.name() + " ");
        System.out.print(getBallCount() + BaseBallGameRule.BALL.name() + " ");
        System.out.print(getOutCount() + BaseBallGameRule.OUT.name() + " ");
        System.out.println();
    }

}
