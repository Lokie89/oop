package test;

import m01baseball.BaseBallGameNumber;
import m01baseball.RandomNumberGenerator;

public class M1BaseballTest extends Thread {
    public static void main(String[] args) {
        final int min = 0;
        final int max = 9;
        final int randomNumber = new RandomNumberGenerator(min, max).getRandomNumber();
        Assert.assertTrue(min <= randomNumber && randomNumber <= max);
        Assert.assertTrue(new BaseBallGameNumber(3).isSameNumber(3));
        Assert.assertTrue(new BaseBallGameNumber(5).isSameNumber(3));
    }

}

