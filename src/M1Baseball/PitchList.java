package M1Baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PitchList {
    private List<Pitch> pitchList;

    public PitchList(NumberList numberList1, NumberList numberList2) {
        if (!numberList1.isSameSize(numberList2)) {
            throw new CannotCompareError();
        }
        this.pitchList = getPitchList(numberList1, numberList2);
    }

    private List<Pitch> getPitchList(NumberList numberList1, NumberList numberList2) {
        List<Pitch> pitchList = new ArrayList<>();
        final int compareSize = numberList1.getNumberList().size();
        boolean[] isExactlySame = numberList1.isExactlySame(numberList2);
        boolean[] isContains = numberList1.isContains(numberList2);
        if (isExactlySame.length != isContains.length) {
            throw new CannotCompareError();
        }
        for (int i = 0; i < compareSize; i++) {
            pitchList.add(getPitch(isExactlySame[i], isContains[i]));
        }
        return pitchList;
    }

    private Pitch getPitch(boolean isStrike, boolean isBall) {
        if (isStrike) {
            return Pitch.STRIKE;
        }
        if (isBall) {
            return Pitch.BALL;
        }
        return Pitch.OUT;
    }

    public void print() {
        System.out.println(
                getStrikeCount() + " " + Pitch.STRIKE.getPitchKorean() + " "
                + getBallCount() + " " + Pitch.BALL.getPitchKorean() + " "
                + getOutCount() + " " + Pitch.OUT.getPitchKorean() + " "
        );
    }

    public int getOutCount() {
        return pitchList
                .stream()
                .filter(pitch -> pitch.equals(Pitch.OUT))
                .collect(Collectors.toList())
                .size()
                ;
    }

    public int getStrikeCount() {
        return pitchList
                .stream()
                .filter(pitch -> pitch.equals(Pitch.STRIKE))
                .collect(Collectors.toList())
                .size()
                ;
    }

    public int getBallCount() {
        return pitchList
                .stream()
                .filter(pitch -> pitch.equals(Pitch.BALL))
                .collect(Collectors.toList())
                .size()
                ;
    }
}
