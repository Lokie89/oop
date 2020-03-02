package m1baseball.member.baseball;

import m1baseball.exception.ParsingException;
import m1baseball.game.CustomNumberList;
import m1baseball.game.NumberList;
import m1baseball.member.Member;

public class BaseBallPlayer extends Member {


    public BaseBallPlayer(String name) {
        super(name);
    }

    public NumberList getNumberList() throws ParsingException {
        System.out.println("Pitcher : " + name);
        final int size = 3;
        final String info = size + "가지의 중복되지 않은 숫자를 적어 주세요.";
        final String splitStr = ",";
        return new CustomNumberList(splitStr, info);
    }

}
