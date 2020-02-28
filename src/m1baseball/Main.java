package m1baseball;

import m1baseball.game.Game;
import m1baseball.game.GamePack;

public class Main {
    public static void main(String[] args) {
        new Game(GamePack.BASEBALL).play();
    }
}
