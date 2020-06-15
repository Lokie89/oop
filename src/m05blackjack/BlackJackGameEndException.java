package m05blackjack;

public class BlackJackGameEndException extends RuntimeException implements BlackJackGameException {
    private String message = "게임이 종료 되었습니다. ";

    public BlackJackGameEndException(){}
    public BlackJackGameEndException(String message) {
        this.message += message;
    }

    @Override
    public void printException() {
        System.out.println(this.message);
    }
}
