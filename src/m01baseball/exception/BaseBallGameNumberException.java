package m01baseball.exception;

public class BaseBallGameNumberException extends BaseBallGameException {

    public BaseBallGameNumberException() {
        super("0 ~ 9 까지 숫자를 입력하여 주세요.");
    }

}
