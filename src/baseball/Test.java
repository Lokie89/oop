package baseball;

import baseball.generator.Generatable;
import baseball.generator.LowerAlphabetGenerator;
import baseball.generator.RandomNumberGenerator;
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

        System.out.println(generatedCharacter);
        for (char excludeCharacter : excludeCharacters) {
            Assert.assertTrue(generatedCharacter != excludeCharacter);
        }
    }

    public static void main(String[] args) {

        randomNumberGeneratorTest();
        lowerAlphabetGeneratorTest();

    }
}
