package m03lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BettingNumberList extends LottoNumberList {

    public BettingNumberList() {
        super(new ArrayList<>());
        setLottoNumberList();
    }


    private boolean isContainLottoNumber(LottoNumber validateLottoNumber) {
        return lottoNumberList
                .stream()
                .filter(lottoNumber -> lottoNumber.isEqualLottoNumber(validateLottoNumber))
                .count() > 0;
    }

    private void setLottoNumberList() {
            setLottoNumber();
    }

    private void setLottoNumber() {
        lottoNumberList.add(getLottoNumber());
    }

    private LottoNumber getLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        try {
            validateLottoNumber(lottoNumber);
        } catch (LottoException e) {
            return getLottoNumber();
        }
        return lottoNumber;
    }

    private void validateLottoNumber(LottoNumber lottoNumber) throws LottoException {
        if (isContainLottoNumber(lottoNumber)) {
            throw new LottoException();
        }
    }

    private boolean isLottoUnderSize() {
        final int lottoSize = 6;
        return lottoNumberList.size() < lottoSize;
    }

    public void print() {
        final int lottoNumberListSize = lottoNumberList.size();
        for (int i = 0; i < lottoNumberListSize; i++) {
            lottoNumberList.get(i).print();
            System.out.print(", ");
        }
        System.out.println();
    }


}
