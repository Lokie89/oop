package m05blackjack.participant;

import m05blackjack.card.CardList;
import m05blackjack.deck.CardDeck;

import java.util.ArrayList;

public class BlackJackDealer extends BlackJackParticipantImpl {

    public BlackJackDealer() {
        super(new CardList(new ArrayList<>()));
    }

    @Override
    public void hit(CardDeck cardDeck) {
        if (isStableNumberArea()) {
            throw new BlackJackDealerStopHitException();
        }
        super.hit(cardDeck);
        return;
    }

    private boolean isStableNumberArea() {
        return super.getCardSum() > 18 && super.getCardSum() < 21;
    }

}
