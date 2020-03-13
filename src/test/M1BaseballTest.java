package test;

import m01baseball.baseballgame.BaseBallGame;
import m01baseball.baseballgame.BaseBallGameNumber;
import m01baseball.baseballgame.BaseBallGameNumberList;
import m01baseball.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class M1BaseballTest extends Thread {
    public static void main(String[] args) {
        final int min = 0;
        final int max = 9;
        final int randomNumber = new RandomNumberGenerator(min, max).getRandomNumber();
        Assert.assertTrue(min <= randomNumber && randomNumber <= max);
//        Assert.assertTrue(new BaseBallGameNumber(5).isSameNumber(3));

        List<BaseBallGameNumber> baseBallGameNumbers1 = new ArrayList<>();
        baseBallGameNumbers1.add(new BaseBallGameNumber(3));
        baseBallGameNumbers1.add(new BaseBallGameNumber(5));
        baseBallGameNumbers1.add(new BaseBallGameNumber(4));
        List<BaseBallGameNumber> baseBallGameNumbers2 = new ArrayList<>();
        baseBallGameNumbers2.add(new BaseBallGameNumber(3));
        baseBallGameNumbers2.add(new BaseBallGameNumber(4));
        baseBallGameNumbers2.add(new BaseBallGameNumber(8));

        BaseBallGameNumberList baseBallGameNumberList1 = new BaseBallGameNumberList(baseBallGameNumbers1);
        BaseBallGameNumberList baseBallGameNumberList2 = new BaseBallGameNumberList(baseBallGameNumbers2);

        boolean[][] test = baseBallGameNumberList1.getContainSame(baseBallGameNumberList2);
        for(boolean[] t : test){
            System.out.print(t[0]+" ");
            System.out.println(t[1]);
        }

        new BaseBallGame().play();
    }

}

