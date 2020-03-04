package m03lotto.lotto;

import m03lotto.RandomNumberGenerator;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber() {
        int lottoNumber = getLottoNumber();
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private int getLottoNumber() {
        final int lowNumber = 1;
        final int highNumber = 45;
        final int lottoNumber = RandomNumberGenerator.generate(lowNumber, highNumber);
        try {
            validateLottoNumber(lottoNumber);
        } catch (LottoException e) {
            e.printMessage();
            return getLottoNumber();
        }
        return lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (!isProfitLottoNumber(lottoNumber)) {
            throw new LottoException("1 ~ 45 사이의 숫자만 입력할 수 있습니다.");
        }
    }

    private boolean isProfitLottoNumber(int lottoNumber) {
        final int lowNumber = 1;
        final int highNumber = 45;
        return lowNumber <= lottoNumber && lottoNumber <= highNumber;
    }

    public boolean isEqualLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumber == lottoNumber.lottoNumber;
    }

    public void print() {
        System.out.print(lottoNumber);
    }

}
