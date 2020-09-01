package baseball.refree;

import java.util.Optional;

public interface Judgeable<T> {
    Optional<T> judge(T compare);
}
