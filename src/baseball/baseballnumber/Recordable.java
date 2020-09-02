package baseball.baseballnumber;

import baseball.record.Decidable;

public interface Recordable<T> {
    Decidable getCompareRecord(T recordable);
}
