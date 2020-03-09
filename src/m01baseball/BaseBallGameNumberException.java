package m01baseball;

public class BaseBallGameNumberException extends RuntimeException {

    private final String message;

    public BaseBallGameNumberException() {
        message = "0 ~ 9 까지 숫자를 입력하여 주세요.";
    }

    public void print() {
        System.out.println(message);
    }
}
