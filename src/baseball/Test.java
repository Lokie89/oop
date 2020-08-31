package baseball;

import baseball.generator.Generatable;
import baseball.generator.LowerAlphabetGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.generator.UpperAlphabetGenerator;
import test.Assert;

public class Test {

    private static void randomNumberGeneratorTest() {
        RandomNumberGenerator.Builder randomNumberGeneratorBuilder = new RandomNumberGenerator.Builder();
        int max = 6;
        int[] excludeNumbers = new int[]{
                1, 2, 3, 4
        };
        randomNumberGeneratorBuilder = randomNumberGeneratorBuilder
                .max(max)
                .excludeNumbers(excludeNumbers)
        ;
        Generatable<Integer> randomNumberGenerator =
                randomNumberGeneratorBuilder.build();

        int generatedNumber = randomNumberGenerator.getGenerated();

        Assert.assertTrue(generatedNumber < max);
        for (int excludeNumber : excludeNumbers) {
            Assert.assertTrue(generatedNumber != excludeNumber);
        }
    }

    private static void lowerAlphabetGeneratorTest() {
        LowerAlphabetGenerator.Builder lowerAlphabetGeneratorBuilder = new LowerAlphabetGenerator.Builder();
        char[] excludeCharacters = new char[]{
                'a', 'b', 'c', 'd'
        };
        lowerAlphabetGeneratorBuilder = lowerAlphabetGeneratorBuilder
                .excludeCharacters(excludeCharacters)
        ;
        Generatable<Character> lowerAlphabetGenerator =
                lowerAlphabetGeneratorBuilder.build();

        char generatedCharacter = lowerAlphabetGenerator.getGenerated();

        for (char excludeCharacter : excludeCharacters) {
            Assert.assertTrue(generatedCharacter != excludeCharacter);
        }
    }

    private static void upperAlphabetGeneratorTest() {
        UpperAlphabetGenerator.Builder upperAlphabetGeneratorBuilder = new UpperAlphabetGenerator.Builder();
        char[] excludeCharacters = new char[]{
                'A', 'B', 'C', 'D'
        };
        upperAlphabetGeneratorBuilder = upperAlphabetGeneratorBuilder
                .excludeCharacters(excludeCharacters)
        ;
        Generatable<Character> upperAlphabetGenerator =
                upperAlphabetGeneratorBuilder.build();

        char generatedCharacter = upperAlphabetGenerator.getGenerated();

        for (char excludeCharacter : excludeCharacters) {
            Assert.assertTrue(generatedCharacter != excludeCharacter);
        }
    }

    private static void baseBallNumberTest() {
        final int max = 9;
        BaseBallNumber baseBallNumber = new BaseBallNumber(
                new RandomNumberGenerator.Builder()
                        .max(max)
                        .build()
        );
        Assert.assertTrue(baseBallNumber.hashCode() < max);
    }

    private static void baseBallNumbersTest() {

        final int max = 9;
        final int size = 3;
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(
                new RandomNumberGenerator.Builder()
                        .max(max)
                        .build(),
                size
        );
        System.out.println(baseBallNumbers.toString());

    }

    public static void main(String[] args) {
        randomNumberGeneratorTest();
        lowerAlphabetGeneratorTest();
        upperAlphabetGeneratorTest();
        baseBallNumberTest();
        baseBallNumbersTest();
    }
}
