package m01baseball.baseballgame;

import m01baseball.Parsing;
import m01baseball.Player;
import m01baseball.ScanResponse;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGamePlayer extends Player {

    public BaseBallGamePlayer(String name) {
        super(name);
    }

    public BaseBallGameNumberList getBaseBallGameNumberList() {
        final String splitStr = ",";
        final String info = "숫자 " + BaseBallGameNumberList.BASEBALL_NUMBER_SIZE + "개를 입력하세요.";
        String[] responses = ScanResponse.getResponse(splitStr, info);
        return new BaseBallGameNumberList(getBaseBallGameNumberListByResponse(responses));
    }

    private List<BaseBallGameNumber> getBaseBallGameNumberListByResponse(String[] responses) {
        List<BaseBallGameNumber> baseBallGameNumberList = new ArrayList<>();
        for (String response : responses) {
            baseBallGameNumberList.add(new BaseBallGameNumber(strToInteger(response)));
        }
        return baseBallGameNumberList;
    }

    private Integer strToInteger(String str) {
        return Parsing.strToInteger(str);
    }

}
