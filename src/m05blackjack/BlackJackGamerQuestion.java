package m05blackjack;

import java.util.Arrays;

public enum BlackJackGamerQuestion {
    HIT(1),
    STOP(2),
    ;

    private int num;

    BlackJackGamerQuestion(int num) {
        this.num = num;
    }

    public static BlackJackGamerQuestion getBlackJackGamerQuestion(int num) {
        return Arrays.asList(BlackJackGamerQuestion.values())
                .stream()
                .filter(blackJackGamerQuestion -> blackJackGamerQuestion.num == num)
                .findFirst()
                .get()
                ;
    }

    public static void printQuestion() {
        for (BlackJackGamerQuestion blackJackGamerQuestion : BlackJackGamerQuestion.values()) {
            System.out.print(blackJackGamerQuestion.num + ".");
            System.out.println(blackJackGamerQuestion.name() + " ");
        }
    }
}
