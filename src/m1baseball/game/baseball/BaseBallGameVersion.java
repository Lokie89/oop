package m1baseball.game.baseball;

import m1baseball.exception.ContainException;
import m1baseball.game.NumberList;
import m1baseball.member.baseball.BaseBallPlayerType;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BaseBallGameVersion {
    VERSION1("1") {
        public NumberList getQuestion() throws BaseBallGameException {
            return BaseBallPlayerType.RANDOM.getNumberList();
        }
    },
    VERSION2("2") {
        public NumberList getQuestion() throws BaseBallGameException {
            return BaseBallPlayerType.CUSTOM.getNumberList();
        }
    },
    ;

    private String version;

    BaseBallGameVersion(String version) {
        this.version = version;
    }

    public abstract NumberList getQuestion() throws BaseBallGameException;

    private String getVersion() {
        return version;
    }

    public static BaseBallGameVersion getVersion(String version) {
        try {
            return Arrays
                    .stream(BaseBallGameVersion.values())
                    .filter(baseBallGameVersion -> baseBallGameVersion.getVersion().equals(version))
                    .findAny()
                    .orElseThrow()
                    ;
        } catch (NoSuchElementException e) {
            throw new ContainException();
        }
    }
}
