package m01baseball.game.baseball;

import m01baseball.Server;

import java.io.IOException;

public class BaseBallGameServer {
    private final Server receiveServer;
    private final Server sendServer;

    public BaseBallGameServer() throws IOException {
        receiveServer = new Server(BaseBallGameServerPort.RECEIVE.getPortNumber());
        sendServer = new Server(BaseBallGameServerPort.SEND.getPortNumber());
    }
}
