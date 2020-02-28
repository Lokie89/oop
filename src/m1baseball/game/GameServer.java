package m1baseball.game;

import m1baseball.Server;
import m1baseball.game.baseball.BaseBallGameServerPort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private final List<Server> gameServerList;

    public GameServer() throws IOException {
        gameServerList = new ArrayList<>();
        gameServerList.add(new Server(BaseBallGameServerPort.RECEIVE.getPortNumber()));
        gameServerList.add(new Server(BaseBallGameServerPort.SEND.getPortNumber()));
    }

}
