package m01baseball.baseballgame;

import java.util.Arrays;

public enum BaseBallGameRule {
    STRIKE(true, true),
    BALL(true, false),
    OUT(false, false),
    ;

    private boolean isContain;
    private boolean isSame;

    BaseBallGameRule(boolean isContain, boolean isSame) {
        this.isContain = isContain;
        this.isSame = isSame;
    }

    public static BaseBallGameRule getBaseBallGameResult(boolean isContain, boolean isSame) {
        return Arrays.stream(BaseBallGameRule.values())
                .filter(baseBallGameRule -> baseBallGameRule.isContain(isContain) && baseBallGameRule.isSame(isSame))
                .findFirst()
                .orElseThrow(null);
    }

    private boolean isContain(boolean isContain) {
        return this.isContain == isContain;
    }

    private boolean isSame(boolean isSame) {
        return this.isSame == isSame;
    }
}
