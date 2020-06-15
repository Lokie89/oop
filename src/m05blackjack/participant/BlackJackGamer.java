package m05blackjack.participant;

import m05blackjack.card.CardList;

import java.util.ArrayList;

public class BlackJackGamer extends BlackJackParticipantImpl {
    public BlackJackGamer() {
        super(new CardList(new ArrayList<>()));
    }
}

