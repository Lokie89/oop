package M1Baseball;

import java.util.LinkedHashSet;

public class CustomNumberList extends NumberList {

    public CustomNumberList(String info, String splitStr) {
        super(new LinkedHashSet<>());
        insertCustomResponse(getResponseArr(info, splitStr));
    }

    private String[] getResponseArr(String info, String splitStr) {
        String customResponse = new CustomScanner(info, splitStr).getResponse();
        return customResponse.split(splitStr);
    }

    private void insertCustomResponse(String[] customResponseArr) {
        for (String response : customResponseArr) {
            getNumberList().add(Integer.parseInt(response));
        }
    }

}
