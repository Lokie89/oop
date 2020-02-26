package m1baseball.game.baseball;

import m1baseball.game.Game;

public class BaseBallGame extends Game {

    @Override
    public String request() {
        return "abab";
    }

    @Override
    public Object response() {
        return super.response();
    }
}
