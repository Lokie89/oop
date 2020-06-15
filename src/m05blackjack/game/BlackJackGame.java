package m05blackjack.game;

import m05blackjack.BlackJackGameEndException;
import m05blackjack.BlackJackGamerQuestion;
import m05blackjack.BlackJackRecord;
import m05blackjack.deck.BlackJackCardDeck;
import m05blackjack.deck.CardDeck;
import m05blackjack.participant.*;

import java.util.Scanner;

public class BlackJackGame implements Game {

    private CardDeck cardDeck;
    private BlackJackParticipant blackJackDealer;
    private BlackJackParticipant blackJackGamer;

    private boolean isDealerStop;
    private boolean isGamerStop;

    public BlackJackGame() {
        cardDeck = new BlackJackCardDeck();
        blackJackDealer = new BlackJackDealer();
        blackJackGamer = new BlackJackGamer();
    }

    @Override
    public void play() {
        bothHitAndPrint();
        bothHitAndPrint();
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                BlackJackGamerQuestion.printQuestion();
                blackJackGamerHitOrStop(BlackJackGamerQuestion.getBlackJackGamerQuestion(scanner.nextInt()));
                blackJackDealerHitOrStop();
                bothPrint();
                checkDealerAndGamerWantStop();
            }
        } catch (BlackJackParticipantBurstException | BlackJackGameEndException e) {
            BlackJackRecord gamerRecord = blackJackGamer.checkCard();
            BlackJackRecord dealerRecord = blackJackDealer.checkCard();
            bothPrint();
            gamerRecord.compareRecord(dealerRecord);
        }

    }

    private void checkDealerAndGamerWantStop() {
        if (isDealerAndGamerWantStop()) {
            throw new BlackJackGameEndException();
        }
    }

    private boolean isDealerAndGamerWantStop() {
        return isDealerStop && isGamerStop;
    }

    private void blackJackGamerHitOrStop(BlackJackGamerQuestion blackJackGamerQuestion) {
        if (isGamerWantHit(blackJackGamerQuestion)) {
            blackJackGamer.hit(cardDeck);
            return;
        }
        isGamerStop = true;
    }

    private void blackJackDealerHitOrStop() {
        try {
            blackJackDealer.hit(cardDeck);
        } catch (BlackJackDealerStopHitException e) {
            isDealerStop = true;
        }
    }

    private boolean isGamerWantHit(BlackJackGamerQuestion blackJackGamerQuestion) {
        return blackJackGamerQuestion.equals(BlackJackGamerQuestion.HIT);
    }

    private void bothHitAndPrint() {
        bothHit();
        bothPrint();
    }

    private void bothHit() {
        blackJackDealer.hit(cardDeck);
        blackJackGamer.hit(cardDeck);
    }

    private void bothPrint() {
        System.out.println("----- DEALER -----");
        blackJackDealer.printCard();
        System.out.println("----- GAMER -----");
        blackJackGamer.printCard();
    }

}
