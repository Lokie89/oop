package m01baseball.game;

import m01baseball.CustomScanner;
import m01baseball.Parsing;
import m01baseball.exception.ParsingException;

public class Game {

    private final GamePack gamePack;

    public Game(GamePack gamePack) {
        this.gamePack = gamePack;
    }

    private void printStartGame() {
        System.out.print(gamePack.getGameName());
        System.out.println(" Game 을 시작합니다.");
    }

    public void play() {
        printStartGame();
        do {
            gamePack.play();
        } while (isGoingReGame(askReGame()));
        printEndGame();
    }

    private void printEndGame() {
        System.out.print(gamePack.getGameName());
        System.out.println(" Game 을 종료합니다.");
    }

    private boolean isGoingReGame(int answer) {
        return answer == 1;
    }

    private Integer askReGame() throws ParsingException {
        final String info = "게임을 더 하시겠습니까? \n 1. 한번더 2. 종료";
        try {
            return Parsing.strToInteger(new CustomScanner(info).getFirstResponse()[0]);
        } catch (ParsingException e) {
            e.printMessage();
            return askReGame();
        }
    }

}
