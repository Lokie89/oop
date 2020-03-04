package m03lotto.lotto;

import java.util.List;

public class LottoNumberList {
    private final List<LottoNumber> lottoNumberList;

    public LottoNumberList(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    protected boolean isLottoUnderSize() {
        final int lottoSize = 6;
        return lottoNumberList.size() < lottoSize;
    }

    public void printLottoNumber() {
        final int lottoNumberListSize = lottoNumberList.size();
        for (int i = 0; i < lottoNumberListSize; i++) {
            lottoNumberList.get(i).print();
            System.out.print(", ");
        }
    }

    protected boolean isContainLottoNumber(LottoNumber validateLottoNumber) {
        return lottoNumberList
                .stream()
                .filter(lottoNumber -> lottoNumber.isEqualLottoNumber(validateLottoNumber))
                .count() > 0;
    }


    protected void validateContainLottoNumber(LottoNumber lottoNumber) {
        if (isContainLottoNumber(lottoNumber)) {
            throw new LottoException("중복된 번호입니다. 다시 입력하여 주세요.");
        }
    }

    private boolean isLottoOverSize() {
        final int lottoSize = 6;
        return lottoNumberList.size() >= lottoSize;
    }

    private void validateOverLottoSize() {
        if (isLottoOverSize()) {
            throw new LottoException("더이상 입력하실 수 없습니다.");
        }
    }

    protected void addLottoNumber(LottoNumber lottoNumber) {
        validateOverLottoSize();
        lottoNumberList.add(lottoNumber);
    }

    protected int getSize() {
        return lottoNumberList.size();
    }

    protected long getContainCount(LottoNumberList lottoNumberList) {
        long containCount = this.lottoNumberList
                .stream().filter(lottoNumberList::isContainLottoNumber).count();
        return containCount;
    }

}
