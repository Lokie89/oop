package m01baseball;

public class RandomNumberGeneratorException extends RuntimeException {
    private final String message;

    public RandomNumberGeneratorException(){
        message = "start 와 end 의 크기를 알맞게 적어주세요";
    }

    public void print(){
        System.out.println(message);
    }
}
