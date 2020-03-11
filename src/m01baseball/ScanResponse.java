package m01baseball;

import java.util.Scanner;

public class ScanResponse {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getResponse(String splitStr, String info) {
        info = info + " 구분 ( " + splitStr + " ) ";
        System.out.println(info);
        String response = scanner.nextLine();
        return response.split(splitStr);
    }

    public static String getResponse(String info) {
        System.out.println(info);
        String response = scanner.nextLine();
        return response;
    }
}
