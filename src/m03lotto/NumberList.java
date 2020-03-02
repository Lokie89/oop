package m03lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumberList {
    // index 활용 위함
    private List<Integer> numberList;

    private List<Integer> collectionToList(Collection<Integer> numberList) {
        List<Integer> integerList = new ArrayList<>();
        for (int number : numberList) {
            integerList.add(number);
        }
        return integerList;
    }

    protected void setNumberList(Collection<Integer> numberList) {
        this.numberList = collectionToList(numberList);
    }

    public List<Boolean> getIsContainNumberList(NumberList compareNumberList) throws LottoException {
        canCompare(compareNumberList);
        return getIsContainNumberResult(compareNumberList);
    }

    private List<Boolean> getIsContainNumberResult(NumberList compareNumberList) {
        final List<Boolean> isContainResult = new ArrayList<>();
        final int compareSize = compareNumberList.numberList.size();
        for (int i = 0; i < compareSize; i++) {
            isContainResult.add(isContainNumber(compareNumberList.numberList.get(i)));
        }
        return isContainResult;
    }

    private boolean isContainNumber(Integer number) {
        return numberList.contains(number);
    }

    public List<Boolean> getIsSameNumberList(NumberList compareNumberList) throws LottoException {
        canCompare(compareNumberList);
        return getIsSameNumberListResult(compareNumberList);
    }

    private List<Boolean> getIsSameNumberListResult(NumberList compareNumberList) {
        final List<Boolean> isSameResult = new ArrayList<>();
        final int compareSize = compareNumberList.numberList.size();
        for (int i = 0; i < compareSize; i++) {
            isSameResult.add(isSameNumber(numberList.get(i), compareNumberList.numberList.get(i)));
        }
        return isSameResult;
    }

    private boolean isSameNumber(int number1, int number2) {
        return number1 == number2;
    }

    private void canCompare(NumberList compareNumberList) throws LottoException {
        if (!isSameSize(compareNumberList)) {
            throw new LottoException("사이즈가 같지 않습니다. 확인하여 주세요.");
        }
    }

    private boolean isSameSize(NumberList compareNumberList) {
        return numberList.size() == compareNumberList.numberList.size();
    }

    public void isProfitBetweenNumbers(int smallerNumber, int biggerNumber) throws LottoException {
        final int numberListSize = numberList.size();
        for (int i = 0; i < numberListSize; i++) {
            isProfitBetweenNumbers(numberList.get(i), smallerNumber, biggerNumber);
        }
    }

    private void isProfitBetweenNumbers(int number, int smallerNumber, int biggerNumber) throws LottoException {
        final boolean isProfit = number >= smallerNumber && number <= biggerNumber;
        if (!isProfit) {
            throw new LottoException("0 ~ 9 사이의 숫자만 입력할 수 있습니다.");
        }
    }

}
