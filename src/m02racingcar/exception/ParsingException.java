package m02racingcar.exception;

public class ParsingException extends NumberFormatException {
    private String message;


    public ParsingException() {
        message = "잘못 입력하였습니다. 숫자를 입력하여 주세요.";
    }

    public ParsingException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
