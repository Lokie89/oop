package m01baseball;

public class BaseBallGameNumberListException extends RuntimeException {

    private final String message;

    public BaseBallGameNumberListException() {
        this.message = "사이즈가 다릅니다.";
    }

    public void print() {
        System.out.println(message);
    }
}
