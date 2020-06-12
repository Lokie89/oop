package m05blackjack;

import java.util.ArrayList;

public class Dealer extends BlackJackParticipantImpl {

    public Dealer() {
        super(new CardList(new ArrayList<>()));
    }

    @Override
    public void hit(BlackJackCardDeck cardDeck) {
        if (isDealerHitRule()) {
            super.hit(cardDeck);
            return;
        }
        throw new BlackJackGameDealerUnavailableHitException();
    }

    private boolean isDealerHitRule() {
        return cardList.getSum() < 16;
    }
}
