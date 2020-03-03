package m01baseball.game.baseball;

import m01baseball.Parsing;
import m01baseball.exception.ContainException;
import m01baseball.exception.MinusException;
import m01baseball.exception.ParsingException;
import m01baseball.game.CustomScanner;
import m01baseball.game.NumberList;
import m01baseball.member.baseball.BaseBallPlayer;
import m01baseball.member.baseball.BaseBallPlayerType;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    private final NumberList gameNumberList;
    private final List<BaseBallPlayer> baseBallPlayerList;
    private final int pitchLimit;
    private int pitchCount = 0;
    private boolean isGameOver = false;

    public BaseBallGame() {
        this.pitchLimit = getPitchLimit();
        gameNumberList = scanVersion().getQuestion();
        isProfitRule();
        baseBallPlayerList = new ArrayList<>();
        getBaseBallPlayerList();
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

    private BaseBallGameVersion scanVersion() throws ParsingException {
        final String info = "버전을 선택하세요 \n 1. Random, 2. Custom";
        String[] responseStr = new CustomScanner(info).getFirstResponse();
        try {
            Parsing.strToInteger(responseStr);
            return BaseBallGameVersion.getVersion(responseStr[0]);
        } catch (ParsingException e) {
            e.printMessage();
            return scanVersion();
        } catch (ContainException e) {
            e.printMessage();
            return scanVersion();
        }
    }

    private void isProfitRule() throws BaseBallGameException {
        final int smallerNumber = 0;
        final int biggerNumber = 9;
        gameNumberList.isProfitBetweenNumbers(smallerNumber, biggerNumber);
    }

    private int scanHowManyPlayer() throws ParsingException {
        final String info = "플레이어는 몇명입니까?";
        String[] firstResponse = new CustomScanner(info).getFirstResponse();
        return Parsing.strToInteger(firstResponse[0]);
    }

    private void getBaseBallPlayerList() {
        try {
            final int playerCount = scanHowManyPlayer();
            validationIsMinus(playerCount);
            for (int i = 0; i < playerCount; i++) {
                baseBallPlayerList.add(getBaseBallPlayer(i + 1));
            }
        } catch (ParsingException e) {
            e.printMessage();
            getBaseBallPlayerList();
        } catch (MinusException e) {
            e.printMessage();
            getBaseBallPlayerList();
        }

    }

    private BaseBallPlayer getBaseBallPlayer(int order) {
        final String playerTypeStr = getBaseBallPlayerType(order);
        BaseBallPlayerType baseBallPlayerType;
        try {
            baseBallPlayerType = BaseBallPlayerType.getBaseBallPlayerType(playerTypeStr);
        } catch (ContainException e) {
            e.printMessage();
            return getBaseBallPlayer(order);
        }
        final String name = getBaseBallPlayerName();
        return new BaseBallPlayer(baseBallPlayerType, name);
    }

    private String getBaseBallPlayerType(int order) {
        final String infos = order + "번째 플레이어는 누구입니까? 1. CUSTOM( HUMAN ), 2. RANDOM( COMPUTER )";
        String[] responseList = new CustomScanner(infos).getFirstResponse();
        String playerTypeStr = responseList[0];
        try {
            Parsing.strToInteger(playerTypeStr);
            return playerTypeStr;
        } catch (ParsingException e) {
            e.printMessage();
            return getBaseBallPlayerType(order);
        }
    }

    private String getBaseBallPlayerName() {
        final String infos = "그/그녀 의 이름은 무엇입니까?";
        String[] responseList = new CustomScanner(infos).getFirstResponse();
        try {
            validationSameName(responseList[0]);
        } catch (BaseBallGameException e) {
            e.printMessage();
            return getBaseBallPlayerName();
        }
        return responseList[0];
    }

    private void validationSameName(String name) throws BaseBallGameException {
        if (isAlreadyExistName(name)) {
            throw new BaseBallGameException("같은 이름이 있습니다. 다시 입력해 주세요.");
        }
    }

    private boolean isAlreadyExistName(String name) {
        return baseBallPlayerList
                .stream()
                .filter(baseBallPlayer -> baseBallPlayer.isSameName(name))
                .count()
                > 0;
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
        validationPlayerList();
        checkGame(isOverCount());
        while (!isGameOver()) {
            pitchByPlayerList();
        }
    }

    private void validationPlayerList() throws BaseBallGameException {
        if (!isPlayerExist()) {
            throw new BaseBallGameException("참가 인원이 부족합니다.");
        }
    }

    private boolean isPlayerExist() {
        return baseBallPlayerList.size() > 0;
    }


    private boolean isOverCount() {
        return pitchCount >= pitchLimit;
    }

    private void pitchByPlayerList() {
        int turn = 0;
        while (!isGameOver() && isTurnNotOverPlayerSize(turn)) {
            try {
                pitchByPlayer(baseBallPlayerList.get(turn));
            } catch (BaseBallGameException e) {
                e.printMessage();
                turn--;
            } catch (ParsingException e) {
                e.printMessage();
                turn--;
            }
            turn++;
            checkGame(isOverCount());
        }
    }

    private boolean isTurnNotOverPlayerSize(int turn) {
        final int playerSize = baseBallPlayerList.size();
        return turn < playerSize;
    }

    private void pitchByPlayer(BaseBallPlayer baseBallPlayer) throws BaseBallGameException {
        System.out.println((pitchCount + 1) + " / " + pitchLimit + " Pitching");
        PitchResultList pitchResultList = getPitchResult(baseBallPlayer.getNumberList());
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
