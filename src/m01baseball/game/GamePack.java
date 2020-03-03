package m01baseball.game;

import m01baseball.game.baseball.BaseBallGame;

import java.util.Arrays;

public enum GamePack {
    BASEBALL("1", "BaseBallGame") {
        public void play() {
            new BaseBallGame().play();
        }
    },
    BULABULA("2", "BulaBula") {
        public void play() {
            new BaseBallGame().play();
        }
    },
    ;

    GamePack(String gameOrder, String gameName) {
        this.gameOrder = gameOrder;
        this.gameName = gameName;
    }

    private String gameOrder;
    private String gameName;

    public abstract void play();

    public String getGameName() {
        return gameName;
    }

    public String getGameOrder() {
        return gameOrder;
    }

    public static GamePack getGamePack(String gameOrder) {
        return Arrays
                .stream(GamePack.values())
                .filter(gamePack -> gamePack.gameOrder.equals(gameOrder))
                .findAny()
                .orElseThrow(null);
    }
}
