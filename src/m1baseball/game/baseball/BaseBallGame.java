package m1baseball.game.baseball;

import m1baseball.Parsing;
import m1baseball.game.CustomScanner;
import m1baseball.game.Game;
import m1baseball.game.NumberList;
import m1baseball.member.baseball.BaseBallPlayer;
import m1baseball.member.baseball.BaseBallPlayerType;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame extends Game {

    private final int pitchLimit;
    private final NumberList gameNumberList;
    private final List<BaseBallPlayer> baseBallPlayerList;
    private int pitchCount = 0;
    private boolean holeInOne = false;

    public BaseBallGame(int pitchLimit) throws Exception {
        this.pitchLimit = pitchLimit;
        gameNumberList = scanVersion().getQuestion();
        isProfitRule();
        baseBallPlayerList = getBaseBallPlayerList();
    }

    private BaseBallGameVersion scanVersion() {
        final String info = "버전을 선택하세요 \n 1. Random, 2. Custom";
        String[] response = new CustomScanner(info).getFirstResponse();
        return BaseBallGameVersion.getVersion(response[0]);
    }

    private void isProfitRule() throws Exception {
        final int smallerNumber = 0;
        final int biggerNumber = 9;
        gameNumberList.isProfitBetweenNumbers(smallerNumber, biggerNumber);
    }

    private int scanHowManyPlayer() throws Exception {
        final String info = "플레이어는 몇명입니까?";
        String[] firstResponse = new CustomScanner(info).getFirstResponse();
        return Parsing.strToInteger(firstResponse[0]);
    }

    private List<BaseBallPlayer> getBaseBallPlayerList() throws Exception {
        final List<BaseBallPlayer> baseBallPlayerList = new ArrayList<>();
        final int playerCount = scanHowManyPlayer();
        for (int i = 0; i < playerCount; i++) {
            baseBallPlayerList.add(getBaseBallPlayer(i + 1));
        }
        return baseBallPlayerList;
    }

    private BaseBallPlayer getBaseBallPlayer(int order) {
        final String[] infos = {order + "번째 플레이어는 누구입니까? 1. CUSTOM( HUMAN ), 2. RANDOM( COMPUTER )", "그/그녀 의 이름은 무엇입니까?"};
        List<String[]> responseList = new CustomScanner(infos).getResponseList();
        String playerTypeStr = responseList.get(0)[0];
        String name = responseList.get(1)[0];
        return new BaseBallPlayer(BaseBallPlayerType.getBaseBallPlayerType(playerTypeStr), name);
    }

    public void play() throws Exception {
        validationPlayerList();
        while (true) {
            pitchByPlayerList();
            if (haveToQuit()) {
                break;
            }
        }
    }

    private void validationPlayerList() throws Exception {
        if (!isPlayerExist()) {
            throw new Exception();
        }
    }

    private boolean isPlayerExist() {
        return baseBallPlayerList.size() > 0;
    }

    private boolean haveToQuit() {
        return isOverCount() || holeInOne;
    }

    private boolean isOverCount() {
        return pitchCount >= pitchLimit;
    }

    // TODO : break, continue 때문에 2depth
    private void pitchByPlayerList() {
        final int playerSize = baseBallPlayerList.size();
        for (int i = 0; i < playerSize; i++) {
            try {
                pitchByPlayer(baseBallPlayerList.get(i));
                if (haveToQuit()) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("잘못된 입력입니다. 다시 입력하여 주세요");
                continue;
            }
        }
    }

    private void pitchByPlayer(BaseBallPlayer baseBallPlayer) throws Exception {
        System.out.println((pitchCount + 1) + " / " + pitchLimit + " Pitching");
        PitchResultList pitchResultList = getPitchResult(baseBallPlayer.getNumberList());
        pitchResultList.print();
        holeInOne = pitchResultList.isAllStrike();
        pitchCount++;
    }

    private PitchResultList getPitchResult(NumberList playerNumberList) throws Exception {
        List<Boolean> isSameList = gameNumberList.getIsSameNumberList(playerNumberList);
        List<Boolean> isContainList = gameNumberList.isContainNumberList(playerNumberList);

        return getPitchResult(isSameList, isContainList);
    }

    private PitchResultList getPitchResult(List<Boolean> isSameList, List<Boolean> isContainList) throws Exception {
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
        return PitchResult.getPitchResult(isSame, isContain);
    }

    private void canGetPitch(List<Boolean> isSameList, List<Boolean> isContainList) throws Exception {
        if (!isSameSize(isSameList, isContainList)) {
            throw new Exception();
        }
    }

    private boolean isSameSize(List<Boolean> isSameList, List<Boolean> isContainList) {
        return isSameList.size() == isContainList.size();
    }


}
