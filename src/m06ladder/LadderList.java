package m06ladder;

import m06ladder.ladder.Ladder;
import m06ladder.person.LadderGamer;

import java.util.List;
import java.util.stream.Collectors;

public class LadderList {

    private List<Ladder> ladderList;

    public LadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
        validateLadderList();
        sortLadderList();
    }

    public void move(LadderGamer gamer) {
        ladderList
                .stream()
                .forEach(ladder -> ladder.cross(gamer))
        ;
        gamer.goDown();
    }

    private void sortLadderList() {
        this.ladderList = this.ladderList
                .stream()
                .sorted(Location::compareTo)
                .collect(Collectors.toList())
        ;
    }

    private void validateLadderList(){

    }

}
