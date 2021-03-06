package m03lotto.lotto;

public class LottoException extends RuntimeException {
    private final String message;

    public LottoException() {
        message = "";
    }

    public LottoException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
