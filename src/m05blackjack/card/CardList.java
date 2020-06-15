package m05blackjack.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardList {
    private List<Card> cardList;

    public CardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void print() {
        printCardCount();
        cardList
                .stream()
                .forEach(card -> card.print())
        ;
        System.out.println();
    }

    public int getSum() {
        return cardList
                .stream()
                .mapToInt(Card::getBlackJackCardNumber)
                .sum()
                ;
    }

    public Card getOneCard() {
        Card card = cardList.get(0);
        cardList.remove(0);
        return card;
    }

    public void mixCard() {
        Random random = new Random();
        List<Card> newCardList = new ArrayList<>();
        while (!isCardListEmpty()) {
            final int index = random.nextInt(cardList.size());
            newCardList.add(cardList.get(index));
            cardList.remove(index);
        }
        cardList = newCardList;
    }

    private void printCardCount() {
        System.out.println("카드 개수 " + cardList.size());
    }

    public void addOneCard(Card oneCard) {
        cardList.add(oneCard);
    }

    private boolean isCardListEmpty() {
        return getSize() <= 0;
    }

    public int getSize() {
        return cardList.size();
    }
}
