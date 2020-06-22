package m07findmine;

public class FindAllMineException extends RuntimeException {
    public FindAllMineException(){
        super("모든 광산을 파헤쳤습니다. 승리!");
    }
}
