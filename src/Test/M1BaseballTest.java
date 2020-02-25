package Test;

import M1Baseball.CustomNumberList;
import M1Baseball.NumberList;
import M1Baseball.RandomNumberGenerator;
import M1Baseball.RandomNumberList;

public class M1BaseballTest {
    public static void main(String[] args) {
        Assert.assertTrue(RandomNumberGenerator.generate(10) < 10 && RandomNumberGenerator.generate(10) >= 0);
        NumberList randomNumberList = new RandomNumberList(10, 3);
        NumberList customNumberList = new CustomNumberList("입력",",");
        System.out.println(randomNumberList.getNumberList());
        System.out.println(customNumberList.getNumberList());
    }
}
