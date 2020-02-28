package m1baseball.member.baseball;

import m1baseball.game.NumberList;
import m1baseball.game.baseball.BaseBallGameException;
import m1baseball.member.Member;

public class BaseBallPlayer extends Member {
    private final BaseBallPlayerType baseBallPlayerType;


    public BaseBallPlayer(BaseBallPlayerType baseBallPlayerType, String name) {
        super(name);
        this.baseBallPlayerType = baseBallPlayerType;
    }

    public NumberList getNumberList() throws BaseBallGameException {
        System.out.println("Pitcher : "+ name);
        return baseBallPlayerType.getNumberList();
    }

}
