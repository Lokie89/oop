package test;


// https://jojoldu.tistory.com/231
public class Assert {

    private Assert() {
    }

    public static void assertTrue(boolean condition) {
        if(!condition){
            throw new AssertionFailedError();
        }
        System.out.println("Test Passed");
    }
}
