package m05blackjack;

public class BlackJackParticipantImpl implements BlackJackParticipant {
    protected CardList cardList;

    public BlackJackParticipantImpl(CardList cardList) {
        this.cardList = cardList;
    }

    @Override
    public void hit(BlackJackCardDeck cardDeck) {
        cardList.addOneCard(cardDeck.getOneCard());
    }

    @Override
    public BlackJackRecord checkCard() {
        return new BlackJackRecord(cardList);
    }

    @Override
    public void printCard() {
        cardList.print();
    }

}
