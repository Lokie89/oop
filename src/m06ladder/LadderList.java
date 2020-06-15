package m06ladder;

import java.util.List;

public class LadderList {
    private List<Ladder> ladderList;

    public LadderList(List<Ladder> ladderList) {
        validateLadderList(ladderList);
        this.ladderList = ladderList;
    }

    private void validateLadderList(List<Ladder> ladderList) {
        if (isHaveDuplicateOrBesideLadder(ladderList)){
            throw new DuplicateOrBesideLadderException();
        }
    }

    private boolean isHaveDuplicateOrBesideLadder(List<Ladder> ladderList) {
        return ladderList
                .stream()
                .filter(ladder1 -> ladderList.stream()
                        .filter(ladder2 -> ladder2.equals(ladder1)).count() > 1
                        && ladderList.stream()
                        .filter(ladder2 -> ladder2.isBesideLadder(ladder1)).count() > 0)
                .count() > 0;
    }

}
