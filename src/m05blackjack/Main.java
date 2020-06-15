package m05blackjack;

import m05blackjack.game.BlackJackGame;
import m05blackjack.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new BlackJackGame();
        game.play();
    }
}
