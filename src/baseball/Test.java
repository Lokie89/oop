package baseball;

import baseball.baseballnumber.BaseBallNumber;
import baseball.baseballnumber.BaseBallNumbers;
import baseball.record.Decidable;
import baseball.generator.Generatable;
import baseball.generator.LowerAlphabetGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.generator.UpperAlphabetGenerator;
import baseball.refree.BaseBallReferee;
import baseball.refree.Referee;
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

        Assert.assertTrue(generatedNumber <= max);
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
        Assert.assertTrue(baseBallNumber.hashCode() <= max);
    }

    private static void baseBallNumbersTest() {
        final int max = 9;
        final int size = 4;
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(
                size,
                new RandomNumberGenerator.Builder()
                        .max(max)
                        .build()
        );
        System.out.println(baseBallNumbers.toString());
    }

    private static void baseBallNumbersTest2() {
        final int size = 3;
        final int[] baseBallNums = new int[]{
                3, 4, 5
        };
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(
                size,
                baseBallNums
        );
        System.out.println(baseBallNumbers.toString());
    }

    private static Decidable baseBallNumbersTest3() {
        final int max = 9;
        final int size = 3;
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(
                size,
                new RandomNumberGenerator.Builder()
                        .max(max)
                        .build()
        );
        System.out.println(baseBallNumbers.toString());

        final int[] baseBallNums = new int[]{
                3, 4, 5
        };
        BaseBallNumbers baseBallNumbers2 = new BaseBallNumbers(
                size,
                baseBallNums
        );
        System.out.println(baseBallNumbers2.toString());
        return baseBallNumbers.getCompareRecord(baseBallNumbers2);
    }

    private static void judgeableTest() {

        final int size = 3;
        final int[] baseBallNums = new int[]{
                3, 4, 5
        };
        BaseBallNumbers baseBallNumbers = new BaseBallNumbers(
                size,
                baseBallNums
        );

        final int[] baseBallNums2 = new int[]{
                3, 4, 5
        };
        BaseBallNumbers baseBallNumbers2 = new BaseBallNumbers(
                size,
                baseBallNums2
        );


        Decidable pitchingRecords = baseBallNumbers.getCompareRecord(baseBallNumbers2);
        Referee referee = new BaseBallReferee();
        referee.judge(pitchingRecords);
        System.out.println(pitchingRecords);
    }

    private static void BaseBallGameTest() {
        BaseBallGame playable = new BaseBallGame.Builder().gameNumber(
                new BaseBallNumbers(3, new RandomNumberGenerator.Builder().max(9).build())
        ).referee(new BaseBallReferee()).build();
        playable.playerBaseBallNumbers(new BaseBallNumbers(3, 1, 2, 3));
        playable.play();
        playable.playerBaseBallNumbers(new BaseBallNumbers(3, 4,5,6));
        playable.play();
    }


    public static void main(String[] args) {
//        randomNumberGeneratorTest();
//        lowerAlphabetGeneratorTest();
//        upperAlphabetGeneratorTest();
//        baseBallNumberTest();
//        baseBallNumbersTest();
//        baseBallNumbersTest2();
//        baseBallNumbersTest3();
//        judgeableTest();
        BaseBallGameTest();
    }
}
