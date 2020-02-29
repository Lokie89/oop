package m1baseball.game;

import m1baseball.Server;
import m1baseball.game.baseball.BaseBallGameServerPort;

import java.io.IOException;

public class GameServer {
    private final Server receiveServer;
    private final Server sendServer;

    public GameServer() throws IOException {
        receiveServer = new Server(BaseBallGameServerPort.RECEIVE.getPortNumber());
        sendServer = new Server(BaseBallGameServerPort.SEND.getPortNumber());
    }

}
