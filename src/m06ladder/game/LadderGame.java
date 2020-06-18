package m06ladder.game;

import m06ladder.LadderList;
import m06ladder.ladder.Ladder;
import m06ladder.person.LadderGamer;
import m06ladder.point.LadderPoint;

import java.util.ArrayList;
import java.util.List;

public class LadderGame implements Game{
    private LadderList ladderList;
    private LadderGamer gamer;

    public LadderGame(List<Ladder> ladderList, int startPoint) {
        this.ladderList = new LadderList(ladderList);
        gamer = new LadderGamer(new LadderPoint(startPoint));
    }

    @Override
    public void play() {
        while (!gamer.isFinish(new LadderPoint(10))) {
            ladderList.move(gamer);
        }
        gamer.printX();
    }

}
