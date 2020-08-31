package baseball.common;

import java.util.Arrays;
import java.util.TreeMap;

public enum PitchingRecord {
    STRIKE(true, true),
    BALL(false, true),
    OUT(false, false),
    ;

    private boolean sameIndexAndNumber;
    private boolean containNumber;

    PitchingRecord(boolean sameIndexAndNumber, boolean containNumber) {
        this.sameIndexAndNumber = sameIndexAndNumber;
        this.containNumber = containNumber;
    }


    public static PitchingRecord getPitchingRecord(boolean sameIndexAndNumber, boolean containNumber) {
        return Arrays.stream(PitchingRecord.values())
                .filter(pitchingRecord -> pitchingRecord.containNumber == containNumber && pitchingRecord.sameIndexAndNumber == sameIndexAndNumber)
                .findFirst()
                .get()
                ;
    }
}
