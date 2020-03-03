package test;

import m01baseball.Client;
import m01baseball.Server;
import m01baseball.game.CustomScanner;

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
