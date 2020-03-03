package m03lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomScanner {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String[]> responseList = new ArrayList<>();
    private final String splitStr;

    public CustomScanner(String splitStr, String... infos) {
        this.splitStr = splitStr;
        setResponseList(infos);
    }

    public CustomScanner(String info) {
        this.splitStr = null;
        setResponseList(info);
    }

    public CustomScanner(String... infos) {
        this.splitStr = null;
        setResponseList(infos);
    }

    public CustomScanner(String splitStr, String info) {
        this.splitStr = splitStr;
        setResponseList(info);
    }

    private void setResponseList(String... infos) {
        final int infosLength = infos.length;
        for (int i = 0; i < infosLength; i++) {
            responseList.add(response(infos[i]));
        }
    }

    private String[] response(String info) {
        System.out.print(info);
        if (isDoingSplit()) {
            System.out.println(" " + splitStr + " 로 구분 ");
            return scanner.nextLine().split(splitStr);
        }
        System.out.println();
        return new String[]{scanner.nextLine()};
    }

    private boolean isDoingSplit() {
        return splitStr != null;
    }

    public List<String[]> getResponseList() {
        return responseList;
    }

    public String[] getFirstResponse() {
        return responseList.get(0);
    }

}

