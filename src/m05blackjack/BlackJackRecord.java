package m05blackjack;

import m05blackjack.card.CardList;

public class BlackJackRecord {

    private static final int BLACKJACK_POINT = 21;

    private boolean burstFlag;
    private boolean blackJackFlag;
    private Integer sum;

    public BlackJackRecord(CardList cardList) {
        judge(cardList);
    }

    private void judge(CardList cardList) {
        blackJackFlag = availableBlackJack(cardList) && isBlackJack(cardList);
        burstFlag = isBurst(cardList);
        sum = cardList.getSum();
    }

    private boolean availableBlackJack(CardList cardList) {
        return cardList.getSize() == 2;
    }

    private boolean isBlackJack(CardList cardList) {
        return cardList.getSum() == BLACKJACK_POINT;
    }

    private boolean isBurst(CardList cardList) {
        return cardList.getSum() > BLACKJACK_POINT;
    }

    public void compareRecord(BlackJackRecord blackJackRecord) {
        try {
            checkBlackJackFlag(blackJackRecord);
            checkBurstFlag(blackJackRecord);
            checkSum(blackJackRecord);
        } catch (BlackJackGameEndException e) {
            e.printException();
        }
    }

    private void checkBlackJackFlag(BlackJackRecord blackJackRecord) {
        if (this.blackJackFlag && isSameBlackJackFlag(blackJackRecord)) {
            throw new BlackJackGameEndException("블랙잭으로 비김");
        }
        if (this.blackJackFlag && !isSameBlackJackFlag(blackJackRecord)) {
            throw new BlackJackGameEndException("블랙잭으로 이김");
        }
        if (!this.blackJackFlag && !isSameBlackJackFlag(blackJackRecord)) {
            throw new BlackJackGameEndException("블랙잭으로 짐");
        }
    }

    private boolean isSameBlackJackFlag(BlackJackRecord blackJackRecord) {
        return this.blackJackFlag == blackJackRecord.blackJackFlag;
    }

    private void checkBurstFlag(BlackJackRecord blackJackRecord) {
        if (this.burstFlag) {
            throw new BlackJackGameEndException("버스트로 짐");
        }
        if (blackJackRecord.burstFlag) {
            throw new BlackJackGameEndException("버스트로 이김");
        }
    }

    private void checkSum(BlackJackRecord blackJackRecord) {
        if (this.sum > blackJackRecord.sum) {
            throw new BlackJackGameEndException("숫자로 이김");
        }
        if (this.sum < blackJackRecord.sum) {
            throw new BlackJackGameEndException("숫자로 짐");
        }
        throw new BlackJackGameEndException("숫자로 비김");
    }


}

