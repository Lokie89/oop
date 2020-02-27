package m1baseball;

import m1baseball.game.baseball.BaseBallGame;

public class Main {
    public static void main(String[] args) {
        try{
            new BaseBallGame(10).play();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
