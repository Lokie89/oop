package m05blackjack;

public enum BlackJackCardNumber {
    A(1),
    N1(1),
    N2(2),
    N3(3),
    N4(4),
    N5(5),
    N6(6),
    N7(7),
    N8(8),
    N9(9),
    N10(10),
    J(10),
    Q(10),
    K(10),
    ;
    private int value;

    BlackJackCardNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
