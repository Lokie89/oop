package m05blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJackCardDeck {
    private CardList cardList;

    public BlackJackCardDeck() {
        setBlackJackCardList();
        mix();
    }

    private void setBlackJackCardList() {
        List<Card> blackJackCardList = new ArrayList<>();
        Arrays.asList(CardType.values())
                .stream()
                .forEach(cardType -> {
                    Arrays.asList(BlackJackCardNumber.values())
                            .stream()
                            .forEach(blackJackCardNumber -> blackJackCardList.add(new Card(cardType, blackJackCardNumber)));
                });
        this.cardList = new CardList(blackJackCardList);
    }

    public void mix() {
        cardList.mixCard();
    }

    public Card getOneCard() {
        return cardList.getOneCard();
    }
}

