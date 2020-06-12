package m05blackjack;

import java.util.ArrayList;

public class Gamer extends BlackJackParticipantImpl {
    public Gamer() {
        super(new CardList(new ArrayList<>()));
    }
}

