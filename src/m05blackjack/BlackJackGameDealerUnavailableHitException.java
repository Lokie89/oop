package m05blackjack;

public class BlackJackGameDealerUnavailableHitException extends RuntimeException{
    public BlackJackGameDealerUnavailableHitException(){
        super("딜러는 더이상 카드를 뽑을 수 없습니다.");
    }
}
