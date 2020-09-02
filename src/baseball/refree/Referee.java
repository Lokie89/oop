package baseball.refree;

import baseball.record.Decidable;

import java.util.Optional;

public abstract class Referee implements Judgeable<Decidable> {
    private final Decidable rule;

    public Referee(Decidable rule) {
        this.rule = rule;
    }

    @Override
    public Optional<Decidable> judge(Decidable compare) {
        if (isWin(compare)) {
            compare.win();
        }
        return Optional.of(compare);
    }

    private boolean isWin(Decidable compare) {
        return compare.equals(rule);
    }
}
