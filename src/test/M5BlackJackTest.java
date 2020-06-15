package test;

import m05blackjack.*;
import m05blackjack.card.BlackJackCardNumber;
import m05blackjack.card.Card;
import m05blackjack.card.CardList;
import m05blackjack.card.CardType;
import m05blackjack.deck.BlackJackCardDeck;
import m05blackjack.participant.BlackJackGameDealerHitRuleException;
import m05blackjack.participant.BlackJackDealer;
import m05blackjack.participant.BlackJackGamer;

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
        BlackJackGamer blackJackGamer = new BlackJackGamer();
        BlackJackCardDeck cardDeck = new BlackJackCardDeck();
        blackJackGamer.printCard();
        blackJackGamer.hit(cardDeck);
        blackJackGamer.printCard();
        blackJackGamer.hit(cardDeck);
        blackJackGamer.printCard();
        blackJackGamer.hit(cardDeck);
        blackJackGamer.printCard();
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
        BlackJackGamer blackJackGamer = new BlackJackGamer();
        BlackJackDealer blackJackDealer = new BlackJackDealer();


        for (int i = 0; i < 3; i++) {

            try {
                blackJackGamer.hit(cardDeck);
                System.out.println("GAMER -- ");
                blackJackGamer.printCard();

                blackJackDealer.hit(cardDeck);
                System.out.println("DEALER -- ");
                blackJackDealer.printCard();
            } catch (BlackJackGameDealerHitRuleException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }


        BlackJackRecord gamerRecord = blackJackGamer.checkCard();
        BlackJackRecord dealerRecord = blackJackDealer.checkCard();
        gamerRecord.compareRecord(dealerRecord);

    }


}
