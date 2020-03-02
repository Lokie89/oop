package m03lotto;

public class LottoException extends Exception {
    private final String message;

    public LottoException() {
        message = "";
    }

    public LottoException(String message) {
        this.message = message;
    }
}
