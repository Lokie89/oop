package baseball.refree;

import baseball.record.PitchingRecord;
import baseball.record.PitchingRecords;
import baseball.record.Recordable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Referee implements Judgeable<Recordable> {
    private final Recordable rule;

    public Referee(PitchingRecords rule) {
        this.rule = rule;
    }
    public Referee() {
        List<PitchingRecord> pitchingRule = new ArrayList<>();
        pitchingRule.add(PitchingRecord.STRIKE);
        pitchingRule.add(PitchingRecord.STRIKE);
        pitchingRule.add(PitchingRecord.STRIKE);
        rule = new PitchingRecords(pitchingRule);
    }


    @Override
    public Optional<Recordable> judge(Recordable compare) {
        if (isWin(compare)) {
            compare.win();
        }
        return Optional.of(compare);
    }

    private boolean isWin(Recordable compare) {
        return compare.equals(rule);
    }
}
