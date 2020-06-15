package m05blackjack.participant;

import m05blackjack.BlackJackRecord;
import m05blackjack.deck.CardDeck;

public interface BlackJackParticipant {
    void hit(CardDeck cardDeck);
    BlackJackRecord checkCard();
    void printCard();
}
