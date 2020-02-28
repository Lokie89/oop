package m1baseball.game;

import m1baseball.Parsing;
import m1baseball.exception.ParsingException;

import java.util.LinkedHashSet;
import java.util.Set;

public class CustomNumberList extends NumberList {
    private final Set<Integer> customNumberList;

    public CustomNumberList(String splitStr, String info) throws ParsingException {
        customNumberList = new LinkedHashSet<>();
        setCustomNumberList(splitStr, info);
        setNumberList(customNumberList);
    }

    private void setCustomNumberList(String splitStr, String info) throws ParsingException {
        final String[] response = scanCustomNumbers(splitStr, info);
        final int responseSize = response.length;
        for (int i = 0; i < responseSize; i++) {
            customNumberList.add(Parsing.strToInteger(response[i]));
        }
    }

    private String[] scanCustomNumbers(String splitStr, String info) {
        return new CustomScanner(splitStr, info).getFirstResponse();
    }
}
