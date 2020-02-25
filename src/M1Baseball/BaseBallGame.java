package M1Baseball;

public class BaseBallGame {

    private NumberList randomNumberList;
    private int pitchCount = 0;
    private final int pitchLimit;
    private final int numberSize;
    private final int limit = 10;


    public BaseBallGame(int numberSize, int pitchLimit) {
        this.pitchLimit = pitchLimit;
        this.numberSize = numberSize;
        this.randomNumberList = new RandomNumberList(limit, numberSize);
    }

    public void run() {
        final String splitStr = ",";
        final String info = "숫자를 입력하세요 " + splitStr;
        while (true) {
            NumberList customNumberList = new CustomNumberList(info, splitStr);
            if (!randomNumberList.isSameSize(customNumberList)) {
                throw new CannotCompareError();
            }
            final PitchList pitchList = new PitchList(randomNumberList, customNumberList);
            pitchList.print();
            if (isGameOver(pitchList)) {
                break;
            }
        }
    }

    private boolean isGameOver(PitchList pitchList) {
        return isAllStrike(pitchList) || isThrowCountOver();
    }

    private boolean isThrowCountOver() {
        return pitchCount >= pitchLimit;
    }

    private boolean isAllStrike(PitchList pitchList) {
        return pitchList.getStrikeCount() == numberSize;
    }

}
