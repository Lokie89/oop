package baseball.baseballnumber;

import baseball.record.PitchingRecord;
import baseball.generator.Generatable;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumbers {
    // 순서 보장
    private final Set<BaseBallNumber> baseBallNumbers = new LinkedHashSet<>();

    public BaseBallNumbers(int size, Generatable<Integer> generator) {
        validateFillableBound(size, generator.getBound());
        generateBaseBallNumbers(size, generator);
    }

    public BaseBallNumbers(int size, int... baseBallNumbers) {
        validateFillableBound(size, baseBallNumbers.length);
        generateBaseBallNumbers(size, baseBallNumbers);
    }

    private void generateBaseBallNumbers(int size, Generatable<Integer> generator) {
        while (!isSameSize(size)) {
            baseBallNumbers.add(getBaseBallNumber(generator));
        }
    }

    private void generateBaseBallNumbers(int size, int[] baseBallNumbers) {
        for (int baseBallNumber : baseBallNumbers) {
            this.baseBallNumbers.add(new BaseBallNumber(baseBallNumber));
        }
        if (!isSameSize(size)) {
            throw new IllegalBaseBallNumbersSizeException();
        }
    }

    private void validateFillableBound(int size, int baseballNumbersSize) {
        if (!isFillableBound(size, baseballNumbersSize)) {
            throw new IllegalBaseBallNumbersSizeException();
        }
    }

    private boolean isFillableBound(int size, int baseballNumbersSize) {
        return baseballNumbersSize >= size;
    }

    private boolean isSameSize(int size) {
        return baseBallNumbers.size() == size;
    }

    private BaseBallNumber getBaseBallNumber(Generatable<Integer> generator) {
        try {
            return new BaseBallNumber(generator);
        } catch (UnboundedBaseBallNumberException e) {
            return getBaseBallNumber(generator);
        }
    }


    public List<PitchingRecord> getCompareRecord(BaseBallNumbers compareBaseBallNumbers) {
        List<PitchingRecord> pitchingRecordList = new ArrayList<>();
        if (!isSameSize(compareBaseBallNumbers.baseBallNumbers.size())) {
            throw new IllegalBaseBallNumbersSizeException();
        }
        BaseBallNumber[] baseBallNumbers = baseBallNumbersSetToArray(this.baseBallNumbers);
        BaseBallNumber[] compareBaseBallNums = baseBallNumbersSetToArray(compareBaseBallNumbers.baseBallNumbers);
        for (int i = 0; i < baseBallNumbers.length; i++) {
            boolean sameIndex = baseBallNumbers[i].equals(compareBaseBallNums[i]);
            boolean containNumber = compareBaseBallNumbers.baseBallNumbers.contains(baseBallNumbers[i]);
            pitchingRecordList.add(PitchingRecord.getPitchingRecord(sameIndex, containNumber));
        }
        return pitchingRecordList;
    }

    private BaseBallNumber[] baseBallNumbersSetToArray(Set<BaseBallNumber> baseBallNumberSet) {
        return baseBallNumberSet.toArray(new BaseBallNumber[baseBallNumberSet.size()]);
    }

    @Override
    public String toString() {
        return baseBallNumbers.toString();
    }
}
