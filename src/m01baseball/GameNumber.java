package m01baseball;

public class GameNumber {
    private final int gameNumber;

    public GameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    protected boolean biggerThan(int compareNumber) {
        return gameNumber >= compareNumber;
    }

    protected boolean lessThan(int compareNumber) {
        return gameNumber <= compareNumber;
    }

    protected boolean isSameNumber(GameNumber gameNumber) {
        return this.gameNumber == gameNumber.gameNumber;
    }

}
