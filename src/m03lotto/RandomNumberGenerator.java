package m03lotto;

public class RandomNumberGenerator {
    public static int generate(int start, int last) {
        return (int) (Math.random() * (last - start + 1)) + start;
    }
}