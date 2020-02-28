package m1baseball.game;

import m1baseball.game.baseball.BaseBallGame;

public enum GamePack {
    BASEBALL("BaseBallGame") {
        public void play() {
            new BaseBallGame().play();
        }
    },
    ;

    GamePack(String gameName) {
        this.gameName = gameName;
    }

    private String gameName;

    public abstract void play();

    public String getGameName() {
        return gameName;
    }
}
