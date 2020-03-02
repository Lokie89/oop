package m03lotto;

import java.util.Set;

public class LottoNumberList extends NumberList {
    private Set<Integer> lottoNumberList;
    private int bonus;

    public LottoNumberList() {

    }

    private void setLottoNumberList() {

    }

    private boolean isLottoSize() {
        final int lottoSize = 6;
        return lottoNumberList.size() == lottoSize;
    }

    private boolean isProfitLottoNumber(int lottoNumber) {
        final int lowNumber = 1;
        final int highNumber = 45;
        return lowNumber <= lottoNumber && lottoNumber <= highNumber;
    }
}
