package baseball.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator implements Generatable<Integer> {
    private final List<Integer> excludeNumbers;
    private final int min;
    private final int max;
    private Integer generatedNumber;

    private int getBound() {
        return max - min;
    }

    private void generate() {
        Random random = new Random();
        generatedNumber = random.nextInt(getBound()) + min;
    }

    private void validateExcludeNumbers() {
        if (isGeneratedNumberIncludedInExcludeNumbers()) {
            throw new GeneratedNumberIsIncludeInExcludeNumbersException();
        }
    }

    private boolean isGeneratedNumberIncludedInExcludeNumbers() {
        return excludeNumbers.stream()
                .filter(n -> n == generatedNumber)
                .count() > 0;
    }

    @Override
    public Integer getGenerated() {
        generate();
        try {
            validateExcludeNumbers();
        } catch (GeneratedNumberIsIncludeInExcludeNumbersException e) {
            getGenerated();
        }
        return generatedNumber;
    }

    public static class Builder {

        private final List<Integer> excludeNumbers = new ArrayList<>();
        private int min = 0;
        private int max = 1;

        // Arrays.asList() 사용 하면 타입매개 변수로 받아야 하는데 그럼 null 체크 해줘야됨
        public Builder excludeNumbers(int... numbers) {
            for (int number : numbers) {
                excludeNumbers.add(number);
            }
            return this;
        }

        public Builder max(int value) {
            this.max = value;
            return this;
        }

        public Builder min(int value) {
            this.min = value;
            return this;
        }

        public RandomNumberGenerator build() {
            return new RandomNumberGenerator(this);
        }
    }

    public RandomNumberGenerator(Builder builder) {
        this.excludeNumbers = builder.excludeNumbers;
        this.min = builder.min;
        this.max = builder.max;
    }
}
