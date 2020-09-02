package baseball;

import baseball.baseballnumber.BaseBallNumbers;
import baseball.record.Decidable;
import baseball.refree.BaseBallReferee;

public class BaseBallGame implements Playable {

    private final BaseBallReferee baseBallReferee;
    private BaseBallNumbers playerBaseBallNumbers;
    private BaseBallNumbers gameBaseBallNumbers;


    public static class Builder {
        private BaseBallNumbers gameBaseBallNumbers;
        private BaseBallReferee baseBallReferee = new BaseBallReferee();

        public Builder referee(BaseBallReferee baseBallReferee) {
            this.baseBallReferee = baseBallReferee;
            return this;
        }

        public Builder gameNumber(BaseBallNumbers baseBallNumbers) {
            this.gameBaseBallNumbers = baseBallNumbers;
            return this;
        }

        public BaseBallGame build(){
            return new BaseBallGame(this);
        }

    }

    public BaseBallGame(Builder builder) {
        this.baseBallReferee = builder.baseBallReferee;
        this.gameBaseBallNumbers = builder.gameBaseBallNumbers;
    }

    public BaseBallGame playerBaseBallNumbers(BaseBallNumbers playerBaseBallNumbers) {
        this.playerBaseBallNumbers = playerBaseBallNumbers;
        return this;
    }


    @Override
    public void play() {
        Decidable decidable = baseBallReferee.judge(playerBaseBallNumbers.getCompareRecord(gameBaseBallNumbers)).get();
        System.out.println(decidable.toString());
    }
}
