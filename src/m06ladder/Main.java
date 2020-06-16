package m06ladder;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new LadderGame().play();
        long endTime = System.currentTimeMillis();
        long differ = endTime - startTime;
        System.out.println(differ + "초");
    }
}
