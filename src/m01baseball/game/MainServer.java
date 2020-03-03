package m01baseball.game;

import m01baseball.Parsing;
import m01baseball.Server;

import java.io.IOException;

public class MainServer {
    private final Server mainReceiveServer;
    private final Server mainSendServer;

    public MainServer() throws IOException {
        mainReceiveServer = new Server(GameServerPort.MAINRECEIVE.getPortNumber());
        mainSendServer = new Server(GameServerPort.MAINSEND.getPortNumber());
    }

    public GamePack openServer() throws IOException {
        String info = "";
        for (GamePack gamePack : GamePack.values()) {
            info += gamePack.getGameOrder() + ". " + gamePack.name() + " ";
        }
        mainSendServer.sendMessage(info);
        String response = mainReceiveServer.receiveMessage();
        Parsing.strToInteger(response);
        return GamePack.getGamePack(response);
    }

}
