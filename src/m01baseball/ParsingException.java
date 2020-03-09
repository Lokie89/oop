package m01baseball;

public class ParsingException extends RuntimeException {
    private final String message;

    public ParsingException() {
        this.message = "숫자가 아닙니다.";
    }

    public void print() {
        System.out.println(message);
    }
}
