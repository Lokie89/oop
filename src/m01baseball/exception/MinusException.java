package m01baseball.exception;

public class MinusException extends Exception {
    private final String message;

    public MinusException(){
        message = "숫자는 0보다 커야 합니다.";
    }
    public MinusException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
