package m02racingcar.exception;

public class ContainException extends RuntimeException{
    private String message;


    public ContainException() {

    }

    public ContainException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

}
