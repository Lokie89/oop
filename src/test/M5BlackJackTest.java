package test;

import m05blackjack.*;

import java.util.ArrayList;
import java.util.List;

public class M5BlackJackTest {
    public static void main(String[] args) {
//        mixTest();
//        hitCard();
//        throwGameEnd();
        recordTest();
    }

    private static void mixTest() {
        List<Card> list = new ArrayList<>();
        list.add(new Card(CardType.CLOVER, BlackJackCardNumber.N1));
        list.add(new Card(CardType.DIAMOND, BlackJackCardNumber.N2));
        list.add(new Card(CardType.HEART, BlackJackCardNumber.N3));
        list.add(new Card(CardType.SPADE, BlackJackCardNumber.A));

        CardList cardList = new CardList(list);
        cardList.print();
        System.out.println("-------------");
        cardList.mixCard();
        cardList.print();
    }

    private static void hitCard() {
        Gamer gamer = new Gamer();
        BlackJackCardDeck cardDeck = new BlackJackCardDeck();
        gamer.printCard();
        gamer.hit(cardDeck);
        gamer.printCard();
        gamer.hit(cardDeck);
        gamer.printCard();
        gamer.hit(cardDeck);
        gamer.printCard();
    }

    private static void throwGameEnd() {
        try {
            throw new BlackJackGameEndException("Gamer 승");
        } catch (BlackJackGameEndException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void recordTest() {
        BlackJackCardDeck cardDeck = new BlackJackCardDeck();
        Gamer gamer = new Gamer();
        Dealer dealer = new Dealer();


        for (int i = 0; i < 3; i++) {

            try {
                gamer.hit(cardDeck);
                System.out.println("GAMER -- ");
                gamer.printCard();

                dealer.hit(cardDeck);
                System.out.println("DEALER -- ");
                dealer.printCard();
            } catch (BlackJackGameDealerUnavailableHitException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }


        BlackJackRecord gamerRecord = gamer.checkCard();
        BlackJackRecord dealerRecord = dealer.checkCard();
        try {
            gamerRecord.compareRecord(dealerRecord);
        } catch (BlackJackGameEndException e) {
            System.out.println(e.getMessage());
        }

    }


}
