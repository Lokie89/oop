package m01baseball.exception;

public class ParsingException extends BaseBallGameException {
    public ParsingException() {
        super("숫자가 아닙니다.");
    }
}
