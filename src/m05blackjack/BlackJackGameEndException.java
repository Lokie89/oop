package m05blackjack;

public class BlackJackGameEndException extends RuntimeException {
    public BlackJackGameEndException(String message) {
        super("게임이 종료 되었습니다. " + message);
    }
}
