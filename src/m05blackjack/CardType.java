package m05blackjack;

public enum CardType {
    DIAMOND("♦"),
    HEART("♥"),
    SPADE("♠"),
    CLOVER("♣"),
    ;
    private String symbol;

    CardType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
