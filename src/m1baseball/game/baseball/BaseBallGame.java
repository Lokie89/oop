package m1baseball.game.baseball;

import m1baseball.Parsing;
import m1baseball.exception.ContainException;
import m1baseball.exception.MinusException;
import m1baseball.exception.ParsingException;
import m1baseball.game.CustomScanner;
import m1baseball.game.NumberList;
import m1baseball.game.RandomNumberList;
import m1baseball.member.baseball.BaseBallPlayer;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private final NumberList gameNumberList;
    private final BaseBallPlayer baseBallPlayer;
    private final int pitchLimit;
    private int pitchCount = 0;
    private boolean isGameOver = false;

    public BaseBallGame() {
        this.pitchLimit = getPitchLimit();
        final int start = 0;
        final int last = 9;
        final int size = 3;
        gameNumberList = new RandomNumberList(start, last, size);
        isProfitRule();
        baseBallPlayer = new BaseBallPlayer(getName());
    }

    private String getName() {
        final String info = "이름이 무엇입니까?";
        return new CustomScanner(info).getFirstResponse()[0];
    }

    private Integer getPitchLimit() {
        final String info = "전부 몇번을 던지겠습니까";
        Integer integer;
        try {
            integer = Parsing.strToInteger(new CustomScanner(info).getFirstResponse()[0]);
            validationIsMinus(integer);
        } catch (ParsingException e) {
            e.printMessage();
            return getPitchLimit();
        } catch (MinusException e) {
            e.printMessage();
            return getPitchLimit();
        }
        return integer;
    }

    private void validationIsMinus(Integer integer) throws MinusException {
        if (isMinus(integer)) {
            throw new MinusException();
        }
    }

    private boolean isMinus(Integer number) {
        return number < 0;
    }

    public void play() {
        try {
            pitch();
        } catch (BaseBallGameException e) {
            e.printMessage();
        } catch (ParsingException e) {
            e.printMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void isProfitRule() throws BaseBallGameException {
        final int smallerNumber = 0;
        final int biggerNumber = 9;
        gameNumberList.isProfitBetweenNumbers(smallerNumber, biggerNumber);
    }

    private void checkGame(boolean checkCondition) {
        if (checkCondition) {
            isGameOver = true;
            System.out.println("게임이 끝났습니다.");
        }
    }

    private boolean isGameOver() {
        return isGameOver;
    }

    private void pitch() throws BaseBallGameException {
        while (!isGameOver()) {
            pitchByPlayer(baseBallPlayer);
            checkGame(isOverCount());
        }
    }

    private boolean isOverCount() {
        return pitchCount >= pitchLimit;
    }


    private void pitchByPlayer(BaseBallPlayer baseBallPlayer) {
        System.out.println((pitchCount + 1) + " / " + pitchLimit + " Pitching");
        PitchResultList pitchResultList = null;
        try {
            pitchResultList = getPitchResult(baseBallPlayer.getNumberList());
        } catch (BaseBallGameException e) {
            e.printMessage();
            pitchByPlayer(baseBallPlayer);
            return;
        } catch (ParsingException e) {
            e.printMessage();
            pitchByPlayer(baseBallPlayer);
            return;
        }
        pitchResultList.print();
        checkGame(pitchResultList.isAllStrike());
        pitchCount++;
    }

    private PitchResultList getPitchResult(NumberList playerNumberList) throws BaseBallGameException {
        List<Boolean> isSameList = gameNumberList.getIsSameNumberList(playerNumberList);
        List<Boolean> isContainList = gameNumberList.getIsContainNumberList(playerNumberList);

        return getPitchResult(isSameList, isContainList);
    }

    private PitchResultList getPitchResult(List<Boolean> isSameList, List<Boolean> isContainList) throws BaseBallGameException {
        canGetPitch(isSameList, isContainList);
        return getPitchResultList(isSameList, isContainList);
    }

    private PitchResultList getPitchResultList(List<Boolean> isSameList, List<Boolean> isContainList) {
        List<PitchResult> pitchResultList = new ArrayList<>();
        final int pitchListSize = isSameList.size();
        for (int i = 0; i < pitchListSize; i++) {
            pitchResultList.add(getPitchResult(isSameList.get(i), isContainList.get(i)));
        }
        return new PitchResultList(pitchResultList);
    }

    private PitchResult getPitchResult(boolean isSame, boolean isContain) {
        try {
            return PitchResult.getPitchResult(isSame, isContain);
        } catch (ContainException e) {
            e.printMessage();
            return null;
        }
    }

    private void canGetPitch(List<Boolean> isSameList, List<Boolean> isContainList) throws BaseBallGameException {
        if (!isSameSize(isSameList, isContainList)) {
            throw new BaseBallGameException("사이즈가 같지 않습니다. 확인하여 주세요.");
        }
    }

    private boolean isSameSize(List<Boolean> isSameList, List<Boolean> isContainList) {
        return isSameList.size() == isContainList.size();
    }


}
