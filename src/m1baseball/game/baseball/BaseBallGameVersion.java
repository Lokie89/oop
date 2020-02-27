package m1baseball.game.baseball;

import m1baseball.game.NumberList;
import m1baseball.member.baseball.BaseBallPlayerType;

import java.util.Arrays;

public enum BaseBallGameVersion {
    VERSION1("1") {
        public NumberList getQuestion() throws Exception {
            return BaseBallPlayerType.RANDOM.getNumberList();
        }
    },
    VERSION2("2") {
        public NumberList getQuestion() throws Exception {
            return BaseBallPlayerType.CUSTOM.getNumberList();
        }
    },
    ;

    private String version;

    BaseBallGameVersion(String version) {
        this.version = version;
    }

    public abstract NumberList getQuestion() throws Exception;

    private String getVersion() {
        return version;
    }

    public static BaseBallGameVersion getVersion(String version) {
        return Arrays
                .stream(BaseBallGameVersion.values())
                .filter(baseBallGameVersion -> baseBallGameVersion.getVersion().equals(version))
                .findAny()
                .orElse(VERSION1)
                ;
    }
}
