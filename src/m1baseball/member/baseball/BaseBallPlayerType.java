package m1baseball.member.baseball;

import m1baseball.game.CustomNumberList;
import m1baseball.game.NumberList;
import m1baseball.game.RandomNumberList;

import java.util.Arrays;

public enum BaseBallPlayerType {
    CUSTOM("1") {
        public NumberList getNumberList() throws Exception{
            final int size = 3;
            final String info = size + "가지의 중복되지 않은 숫자를 적어 주세요.";
            final String splitStr = ",";
            return new CustomNumberList(splitStr, info);
        }
    },
    RANDOM("2") {
        public NumberList getNumberList() throws Exception{
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

    public abstract NumberList getNumberList() throws Exception;

    public static BaseBallPlayerType getBaseBallPlayerType(String type){
        return Arrays
                .stream(BaseBallPlayerType.values())
                .filter(baseBallPlayerType -> baseBallPlayerType.getType().equals(type))
                .findAny()
                .orElse(RANDOM)
                ;
    }
    private String getType(){
        return type;
    }

}
