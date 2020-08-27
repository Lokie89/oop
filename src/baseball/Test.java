package baseball;

import baseball.generator.Generatable;
import baseball.generator.RandomNumberGenerator;

public class Test {
    public static void main(String[] args) {
        Generatable<Integer> numberGenerator =
                new RandomNumberGenerator.Builder()
                        .max(5)
                        .excludeNumbers(1,2)
                        .build();
        System.out.println(numberGenerator.getGenerated());
    }
}
