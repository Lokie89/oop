package baseball.record;

import java.util.Arrays;
import java.util.List;

public class PitchingRecords implements Recordable {
    private final List<PitchingRecord> pitchingRecords;
    private boolean isWin = false;

    public PitchingRecords(List<PitchingRecord> pitchingRecords) {
        this.pitchingRecords = pitchingRecords;
    }

    public PitchingRecords(PitchingRecord... pitchingRecords) {
        this.pitchingRecords = Arrays.asList(pitchingRecords);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PitchingRecords)) {
            return false;
        }
        PitchingRecords comparePitchingRecords = (PitchingRecords) obj;
        return this.pitchingRecords.equals(comparePitchingRecords.pitchingRecords);
    }

    @Override
    public void win() {
        isWin = true;
    }

    @Override
    public String toString() {
        return pitchingRecords.toString() + " " + isWin;
    }
}
