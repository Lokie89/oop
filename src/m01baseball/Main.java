package m01baseball;

import m01baseball.game.Game;
import m01baseball.game.GamePack;

public class Main {
    public static void main(String[] args) {
        new Game(GamePack.BASEBALL).play();
    }
}
