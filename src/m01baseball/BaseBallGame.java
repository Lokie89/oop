package m01baseball;

public class BaseBallGame {
    private final BaseBallGameQuestion baseBallGameQuestion;
    private int pitchLimit = 10;

    public BaseBallGame(BaseBallGameQuestion baseBallGameQuestion) {
        this.baseBallGameQuestion = baseBallGameQuestion;
    }

    public BaseBallGame() {
        baseBallGameQuestion = new BaseBallGameQuestion();
    }


    public void play() {
        while (isPitchable()) {
            pitch();
            decreasePitch();
        }
        end();
    }

    private void pitch() {

    }

    private void end() {
        System.out.println("게임 종료");
    }

    private boolean isPitchable() {
        return pitchLimit > 0;
    }

    private void decreasePitch() {
        pitchLimit--;
    }

    private void confirmRule(BaseBallGameNumber baseBallGameNumber){
        baseba
    }

    private boolean isContain(BaseBallGameNumber baseBallGameNumber){
        baseBallGameQuestion.str
    }


}
