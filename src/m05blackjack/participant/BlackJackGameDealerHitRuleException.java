package m05blackjack.participant;

import m05blackjack.BlackJackGameException;

public class BlackJackGameDealerHitRuleException extends RuntimeException implements BlackJackGameException {

    @Override
    public void printException() {
        System.out.println("딜러는 더이상 카드를 뽑을 수 없습니다.");
    }
}
