package m01baseball.game.baseball;

import m01baseball.exception.ContainException;

import java.util.Arrays;

public enum PitchResult {
    STRIKE(true, true, "Strike", "스트라이크"),
    BALL(false, true, "Ball", "볼"),
    OUT(false, false, "Out", "아웃"),
    ;
    private boolean isSame;
    private boolean isContain;
    private String english;
    private String korean;

    PitchResult(boolean isSame, boolean isContain, String english, String korean) {
        this.isSame = isSame;
        this.isContain = isContain;
        this.english = english;
        this.korean = korean;
    }

    private boolean getIsSame() {
        return isSame;
    }

    private boolean getIsContain() {
        return isContain;
    }

    public static PitchResult getPitchResult(boolean isSame, boolean isContain) throws ContainException {

        return Arrays
                .stream(PitchResult.values())
                .filter(pitchResult -> pitchResult.getIsSame() == isSame && pitchResult.getIsContain() == isContain)
                .findAny()
                .orElseThrow(null);
    }

    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }
}
