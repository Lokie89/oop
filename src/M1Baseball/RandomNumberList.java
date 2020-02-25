package M1Baseball;

import java.util.LinkedHashSet;

public class RandomNumberList extends NumberList {

    public RandomNumberList(int limit, int size) {
        // 순서대로 중복없는 데이터 관리
        super(new LinkedHashSet<>());
        insertRandomNumberLessSize(limit, size);
    }

    private boolean isLessSize(int wantSize) {
        return super.getNumberList().size() < wantSize;
    }


    private void insertRandomNumberLessSize(int limit, int size) {
        while (isLessSize(size)) {
            insertRandomNumberNotOverLap(limit);
        }
    }

    private void insertRandomNumberNotOverLap(int limit) {
        final int randomNumber = RandomNumberGenerator.generate(limit);
//        if (isContain(randomNumber)) {
        super.getNumberList().add(randomNumber);
//        }
    }

    // List 에서 Set 으로 변경하면서 isContain 기능을 사용할 필요가 없어짐
//    private boolean isContain(int randomNumber) {
//        return randomNumberList.contains(randomNumber);
//    }
}
