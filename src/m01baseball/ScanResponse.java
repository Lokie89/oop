package m01baseball;

import java.util.Scanner;

public class ScanResponse {
    private final Scanner scanner = new Scanner(System.in);

    public String[] getResponse(String splitStr, String info) {
        info = info + " ( " + splitStr + " ) ";
        System.out.println(info);
        String response = scanner.nextLine();
        return response.split(splitStr);
    }
}
