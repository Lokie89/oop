package m1baseball.game.baseball;

import java.util.List;

public class PitchResultList {
    private List<PitchResult> pitchResultList;

    public PitchResultList(List<PitchResult> pitchResultList) {
        this.pitchResultList = pitchResultList;
    }

    public void print() {
        for (PitchResult pitchResult : PitchResult.values()) {
            print(pitchResult);
        }
        System.out.println();
        System.out.println();
    }

    // TODO : 영어 한글 등을 지원 할 수 있는 방법 찾기
    private String getName(PitchResult pitchResult) {
        return pitchResult.getKorean();
    }

    private void print(PitchResult pitchResult) {
        final long pitchCount = countPitchResult(pitchResult);
        if (isExistResult(pitchCount)) {
            System.out.print(pitchCount + pitchResult.getKorean() + " ");
        }
    }

    private boolean isExistResult(long count) {
        return count > 0;
    }

    private long countPitchResult(PitchResult comparePitchResult) {
        return pitchResultList.stream().filter(pitchResult -> pitchResult.equals(comparePitchResult)).count();
    }

    public boolean isAllStrike() {
        return countPitchResult(PitchResult.STRIKE) == pitchResultList.size();
    }

}
