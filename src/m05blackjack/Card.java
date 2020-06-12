package m05blackjack;

public class Card {
    private CardType cardType;
    private BlackJackCardNumber blackJackCardNumber;

    public Card(CardType cardType, BlackJackCardNumber blackJackCardNumber) {
        this.cardType = cardType;
        this.blackJackCardNumber = blackJackCardNumber;
    }

    public int getBlackJackCardNumber() {
        return blackJackCardNumber.getValue();
    }

    public void print() {
        System.out.print(cardType.getSymbol() + " " + blackJackCardNumber.name() + "   ");
    }
}
