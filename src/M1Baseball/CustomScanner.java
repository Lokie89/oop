package M1Baseball;

import java.util.Scanner;

public class CustomScanner {

    private String response;
    private final Scanner scanner = new Scanner(System.in);

    public CustomScanner(String info, String... removeStr) {
        scanLine(info);
        removeStr(removeStr);
    }

    private void scanLine(String info) {
        System.out.println(info);
        response = scanner.nextLine();
    }

    private void removeStr(String[] removeStr) {
        final int replaceStrSize = removeStr.length;
        for (int i = 0; i < replaceStrSize; i++) {
            response.replace(removeStr[i], "");
        }
    }

    public String getResponse(){
        return response;
    }

}
