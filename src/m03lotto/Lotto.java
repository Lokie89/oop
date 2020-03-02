package m03lotto;

public class Lotto {
    final int lottoNumber;

    public Lotto() {
        int lottoNumber = getLottoNumber();
        this.lottoNumber = lottoNumber;
    }

    private int getLottoNumber() {
        final int lowNumber = 1;
        final int highNumber = 45;
        return RandomNumberGenerator.generate(lowNumber,highNumber);
    }

    private boolean isProfitLottoNumber(int lottoNumber) {
        final int lowNumber = 1;
        final int highNumber = 45;
        return lowNumber <= lottoNumber && lottoNumber <= highNumber;
    }
}
