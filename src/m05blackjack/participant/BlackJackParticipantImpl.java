package m05blackjack.participant;

import m05blackjack.BlackJackRecord;
import m05blackjack.card.CardList;
import m05blackjack.deck.CardDeck;

public class BlackJackParticipantImpl implements BlackJackParticipant {
    private static final int BLACKJACK_POINT = 21;
    private CardList cardList;

    public BlackJackParticipantImpl(CardList cardList) {
        this.cardList = cardList;
    }

    @Override
    public void hit(CardDeck cardDeck) {
        cardList.addOneCard(cardDeck.getOneCard());
        checkBurst();
    }

    @Override
    public BlackJackRecord checkCard() {
        return new BlackJackRecord(cardList);
    }

    @Override
    public void printCard() {
        cardList.print();
    }

    protected int getCardSum() {
        return cardList.getSum();
    }

    private void checkBurst() {
        if (getCardSum() > BLACKJACK_POINT) {
            throw new BlackJackParticipantBurstException();
        }
    }
}
