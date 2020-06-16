package m06ladder;

import m06ladder.ladder.Ladder;
import m06ladder.person.LadderGamer;

import java.util.List;

public class LadderList {

    private List<Ladder> ladderList;

    public LadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }

    public void move(LadderGamer gamer) {
        if (isOnBridgeLeft(gamer)) {
            gamer.goLeft();
            gamer.goDown();
            return;
        }
        if (isOnBridgeRight(gamer)) {
            gamer.goRight();
            gamer.goDown();
            return;
        }
        gamer.goDown();
    }

    private boolean isOnBridgeLeft(Location gamer) {
        return ladderList
                .stream()
                .filter(ladder -> ladder.isLeftLocation(gamer))
                .count()
                > 0
                ;
    }

    private boolean isOnBridgeRight(Location gamer){
        return ladderList
                .stream()
                .filter(ladder -> ladder.isSameLocation(gamer))
                .count()
                > 0
                ;
    }
}
