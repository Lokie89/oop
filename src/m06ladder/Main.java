package m06ladder;

import m06ladder.game.Game;
import m06ladder.game.LadderGame;
import m06ladder.ladder.Ladder;
import m06ladder.point.LadderPoint;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ladder> ladderList = new ArrayList<>();
        ladderList.add(new Ladder(new LadderPoint(1), new LadderPoint(1)));
        ladderList.add(new Ladder(new LadderPoint(6), new LadderPoint(1)));
        ladderList.add(new Ladder(new LadderPoint(9), new LadderPoint(1)));
        ladderList.add(new Ladder(new LadderPoint(3), new LadderPoint(2)));
        ladderList.add(new Ladder(new LadderPoint(5), new LadderPoint(2)));
        ladderList.add(new Ladder(new LadderPoint(8), new LadderPoint(2)));
        ladderList.add(new Ladder(new LadderPoint(4), new LadderPoint(3)));
        ladderList.add(new Ladder(new LadderPoint(7), new LadderPoint(3)));
        ladderList.add(new Ladder(new LadderPoint(10), new LadderPoint(3)));
        ladderList.add(new Ladder(new LadderPoint(2), new LadderPoint(4)));
        ladderList.add(new Ladder(new LadderPoint(6), new LadderPoint(4)));
        ladderList.add(new Ladder(new LadderPoint(8), new LadderPoint(4)));
        ladderList.add(new Ladder(new LadderPoint(3), new LadderPoint(5)));
        ladderList.add(new Ladder(new LadderPoint(5), new LadderPoint(5)));
        ladderList.add(new Ladder(new LadderPoint(7), new LadderPoint(5)));

        final int startPoint = 3;
        Game ladderGame = new LadderGame(ladderList, startPoint);
        ladderGame.play();
    }
}
