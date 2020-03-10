package m01baseball.exception;

public class RandomNumberGeneratorException extends BaseBallGameException {
    public RandomNumberGeneratorException(){
        super("start 와 end 의 크기를 알맞게 적어주세요");
    }
}
