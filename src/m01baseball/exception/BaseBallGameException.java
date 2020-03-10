package m01baseball.exception;

public class BaseBallGameException extends RuntimeException {

    private final String message;

    public BaseBallGameException(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
