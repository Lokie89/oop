package m01baseball.exception;

public class ParsingException extends RuntimeException {
    private final String message;

    public ParsingException() {
        message = "잘못된 입력입니다. 숫자를 입력하여 주세요";
    }

    public ParsingException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

}
