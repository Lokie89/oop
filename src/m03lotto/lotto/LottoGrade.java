package m03lotto.lotto;

import java.util.Arrays;

public enum LottoGrade {
    FIRST(6, false, "1등"),
    SECOND(5, true, "2등"),
    THIRD(5, false, "3등"),
    FOURTH(4, false, "4등"),
    FIFTH(3, false, "5등"),
    RAINCHECK(0, false, "당첨안됨"),
    ;

    private int containCount;
    private boolean isContainBonus;
    private String gradeStr;

    LottoGrade(int containCount, boolean isContainBonus, String gradeStr) {
        this.containCount = containCount;
        this.isContainBonus = isContainBonus;
        this.gradeStr = gradeStr;
    }

    private boolean isSameContainCount(int containCount) {
        return this.containCount == containCount;
    }

    private boolean isSameContainBonus(boolean isContainBonus) {
        return this.isContainBonus == isContainBonus;
    }


    public void print() {
        System.out.println(gradeStr);
    }

    public static LottoGrade howGrade(int containCount, boolean isContainBonus) {
        return Arrays.stream(LottoGrade.values())
                .filter(lottoGrade -> lottoGrade.isSameContainCount(containCount) && lottoGrade.isSameContainBonus(isContainBonus))
                .findAny()
                .orElse(RAINCHECK)
                ;
    }

}
