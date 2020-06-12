package m05blackjack;

public interface BlackJackParticipant {
    void hit(BlackJackCardDeck cardDeck);
    BlackJackRecord checkCard();
    void printCard();
}
