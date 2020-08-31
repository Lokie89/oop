package baseball.generator;

public interface Generatable<T> {
    T getGenerated();
    int getBound();
}
