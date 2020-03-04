package m01baseball.member.baseball;

import m01baseball.game.NumberList;
import m01baseball.game.baseball.BaseBallGameException;
import m01baseball.member.Member;

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
