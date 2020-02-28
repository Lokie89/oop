package m1baseball.member.baseball;

import m1baseball.exception.ContainException;
import m1baseball.exception.ParsingException;
import m1baseball.game.CustomNumberList;
import m1baseball.game.NumberList;
import m1baseball.game.RandomNumberList;
import m1baseball.game.baseball.BaseBallGameException;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BaseBallPlayerType {
    CUSTOM("1") {
        public NumberList getNumberList() {
            final int size = 3;
            final String info = size + "가지의 중복되지 않은 숫자를 적어 주세요.";
            final String splitStr = ",";
            try {
                return new CustomNumberList(splitStr, info);
            } catch (ParsingException e) {
                e.printMessage();
                return getNumberList();
            }
        }
    },
    RANDOM("2") {
        public NumberList getNumberList() throws BaseBallGameException {
            final int size = 3;
            final int start = 0;
            final int last = 9;
            return new RandomNumberList(start, last, size);
        }
    },
    ;

    BaseBallPlayerType(String type) {
        this.type = type;
    }

    private String type;

    public abstract NumberList getNumberList() throws BaseBallGameException;

    public static BaseBallPlayerType getBaseBallPlayerType(String type) {
        try {
            return Arrays
                    .stream(BaseBallPlayerType.values())
                    .filter(baseBallPlayerType -> baseBallPlayerType.getType().equals(type))
                    .findAny()
                    .orElseThrow()
                    ;
        } catch (NoSuchElementException e) {
            throw new ContainException();
        }
    }

    private String getType() {
        return type;
    }

}
