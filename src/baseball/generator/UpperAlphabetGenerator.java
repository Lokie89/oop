package baseball.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UpperAlphabetGenerator implements Generatable<Character> {
    private final Set<Character> excludeAlphabets;
    private final int min = 65;
    private final int max = 91;
    private Character generatedAlphabet;

    @Override
    public int getBound() {
        return max - min;
    }

    private void generate() {
        Random random = new Random();
        generatedAlphabet = (char) (random.nextInt(getBound()) + min);
    }

    private void validateExcludeNumbers() {
        if (isGeneratedNumberIncludedInExcludeNumbers()) {
            throw new GeneratedSthIsIncludeInExcludeSthsException();
        }
    }

    private boolean isGeneratedNumberIncludedInExcludeNumbers() {
        return excludeAlphabets.stream()
                .filter(n -> n.equals(generatedAlphabet))
                .count() > 0;
    }

    @Override
    public Character getGenerated() {
        generate();
        try {
            validateExcludeNumbers();
        } catch (GeneratedSthIsIncludeInExcludeSthsException e) {
            getGenerated();
        }
        return generatedAlphabet;
    }

    public static class Builder {

        private final Set<Character> excludeAlphabets = new HashSet<>();

        // Arrays.asList() 사용 하면 타입매개 변수로 받아야 하는데 그럼 null 체크 해줘야됨
        public Builder excludeCharacters(char... characters) {
            for (char character : characters) {
                excludeAlphabets.add(character);
            }
            return this;
        }

        public UpperAlphabetGenerator build() {
            return new UpperAlphabetGenerator(this);
        }
    }

    public UpperAlphabetGenerator(Builder builder) {
        this.excludeAlphabets = builder.excludeAlphabets;
    }
}
