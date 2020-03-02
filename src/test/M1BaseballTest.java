package test;

import m1baseball.Client;
import m1baseball.Server;
import m1baseball.game.CustomScanner;
import m1baseball.game.MainServer;

import java.io.IOException;

public class M1BaseballTest {
    public static void main(String[] args) throws IOException {
        new Server(8081).sendMessage(new CustomScanner("dd").getFirstResponse()[0]);
    }
}

class M1BaseBallClient {
    public static void main(String[] args) throws IOException {
        new Client("localhost", 8081).receiveMessage();
    }
}

class M1BaseBallClient2 {
    public static void main(String[] args) throws IOException {
        new Client("localhost", 8082);
    }
}
