package M1Baseball;

import java.util.Set;

public class NumberList {
    private Set<Integer> numberList;

    protected NumberList(Set numberList) {
        this.numberList = numberList;
    }

    public Set<Integer> getNumberList() {
        return numberList;
    }

    public boolean isSameSize(NumberList compareNumberList) {
        return numberList.size() == compareNumberList.getNumberList().size();
    }

    public boolean[] isExactlySame(NumberList compareNumberList) {
        if (!isSameSize(compareNumberList)) {
            throw new CannotCompareError();
        }
        int[] objects1 = numberList.stream().mapToInt(Integer::intValue).toArray();
        int[] objects2 = compareNumberList.getNumberList().stream().mapToInt(Integer::intValue).toArray();
        return getIsSameArray(objects1, objects2);
    }


    public boolean[] isContains(NumberList compareNumberList) {
        Object[] objects = compareNumberList.numberList.toArray();
        return getIsContains(objects);
    }

    private boolean[] getIsContains(Object[] objects) {
        final int compareSize = objects.length;
        boolean[] isContains = new boolean[compareSize];
        for (int i = 0; i < compareSize; i++) {
            isContains[i] = isContain(objects[i]);
        }
        return isContains;
    }

    private boolean isContain(Object obj) {
        return numberList.contains(obj);
    }


    private boolean[] getIsSameArray(int[] objects1, int[] objects2) {
        final int compareSize = objects1.length;
        boolean[] isExactlySame = new boolean[compareSize];
        for (int i = 0; i < compareSize; i++) {
            isExactlySame[i] = isSame(objects1[i], objects2[i]);
        }
        return isExactlySame;
    }

    private boolean isSame(Integer obj1, Integer obj2) {
        return obj1 == obj2;
    }

}
