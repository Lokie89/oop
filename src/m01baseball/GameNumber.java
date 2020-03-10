package m01baseball;

public class GameNumber {
    private final int gameNumber;

    public GameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public boolean biggerThan(int compareNumber) {
        return gameNumber >= compareNumber;
    }

    public boolean lessThan(int compareNumber) {
        return gameNumber <= compareNumber;
    }

    public boolean isSameNumber(GameNumber gameNumber) {
        return this.gameNumber == gameNumber.gameNumber;
    }

}
