package m1baseball.exception;

import java.util.NoSuchElementException;

public class ContainException extends NoSuchElementException {
    private final String message;

    public ContainException() {
        message = "잘못된 입력입니다. 다시 입력하여 주세요.";
    }

    public ContainException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

}
