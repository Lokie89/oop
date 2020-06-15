package m05blackjack.participant;

import m05blackjack.BlackJackGameException;

public class BlackJackParticipantBurstException extends RuntimeException implements BlackJackGameException {
    @Override
    public void printException() {
        System.out.println("카드가 21 을 초과 했습니다.");
    }
}
