package m1baseball;

import m1baseball.game.Game;
import m1baseball.game.GamePack;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Game(GamePack.BASEBALL).play();
    }
}
