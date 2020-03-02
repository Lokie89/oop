package test;

import m01baseball.Client;
import m01baseball.Server;
import m01baseball.game.CustomScanner;

import java.io.IOException;

public class M1BaseballTest extends Thread {
    public static void main(String[] args) {
        new M1BaseballTest().run();
    }

    @Override
    public void run() {
        Server server = null;
        try {
            server = new Server(8082);
            while (true) {
                server.sendMessage(server.receiveMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class M1BaseBallTest3  {
    public static void main(String[] args) {
        Client client;
        try {
            client = new Client("localhost", 8082);
            Thread thread = new Thread(new M1BaseBallTest4(client));
            thread.start();

            while (true) {
                client.receiveMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class M1BaseBallTest4 implements Runnable {
    Client client;

    public M1BaseBallTest4(Client client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            client.sendMessage(new CustomScanner("보낼문자").getFirstResponse()[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
