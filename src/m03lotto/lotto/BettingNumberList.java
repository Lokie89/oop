package m03lotto.lotto;

import m03lotto.CustomScanner;
import m03lotto.Parsing;
import m03lotto.ParsingException;

import java.util.ArrayList;

public class BettingNumberList extends LottoNumberList {
    public BettingNumberList() {
        super(new ArrayList<>());
        setBettingNumberList();
    }

    private void setBettingNumberList() {
        while (isLottoUnderSize()) {
            setBettingNumber();
        }
    }

    private void setBettingNumber() {
        final int bettingNumberInt = getBettingNumberInt();
        try {
            LottoNumber bettingLottoNumber = new LottoNumber(bettingNumberInt);
            validateContainLottoNumber(bettingLottoNumber);
            addLottoNumber(bettingLottoNumber);
        } catch (LottoException e) {
            e.printMessage();
            setBettingNumber();
            return;
        }
    }

    private Integer getBettingNumberInt() {
        final String info = (getSize() + 1) + "번째 로또 숫자를 입력하여 주세요.";
        String lottoNumberStr = new CustomScanner(info).getFirstResponse()[0];
        Integer lottoNumber;
        try {
            lottoNumber = Parsing.strToInteger(lottoNumberStr);
        } catch (ParsingException e) {
            e.printMessage();
            return getBettingNumberInt();
        }
        return lottoNumber;
    }

}
