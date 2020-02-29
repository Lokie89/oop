package m1baseball.game;

import m1baseball.Server;

import java.io.IOException;

public class MainServer {
    private final Server mainReceiveServer;
    private final Server mainSendServer;

    public MainServer() throws IOException {
        mainReceiveServer = new Server(GameServerPort.MAINRECEIVE.getPortNumber());
        mainSendServer = new Server(GameServerPort.MAINSEND.getPortNumber());
    }

    private void readyToReceive() throws IOException {
        final String quitStr = "quit";
        String msg;
        while (!(msg = mainReceiveServer.receiveMessage()).equals(quitStr)) {

        }
    }

    private void readToSend(){

    }
}
