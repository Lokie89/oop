package baseball.refree;

import baseball.record.PitchingRecord;
import baseball.record.PitchingRecords;
import baseball.record.Decidable;

public class BaseBallReferee extends Referee {
    public BaseBallReferee(Decidable rule) {
        super(rule);
    }

    public BaseBallReferee() {
        super(new PitchingRecords(
                PitchingRecord.STRIKE,
                PitchingRecord.STRIKE,
                PitchingRecord.STRIKE
        ));
    }
}
