package m01baseball.game.baseball;

public class BaseBallGameException extends RuntimeException {
    private final String message;

    public BaseBallGameException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

}
