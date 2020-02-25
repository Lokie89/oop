package M1Baseball;

public enum Pitch {
    STRIKE("스트라이크"),
    BALL("볼"),
    OUT("아웃"),
    ;
    private String pitchKorean;

    Pitch(String pitchKorean) {
        this.pitchKorean = pitchKorean;
    }

    public String getPitchKorean() {
        return pitchKorean;
    }

}
