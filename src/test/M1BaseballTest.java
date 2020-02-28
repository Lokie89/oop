package test;

import m1baseball.Client;
import m1baseball.game.CustomScanner;
import m1baseball.Server;

import java.io.IOException;

public class M1BaseballTest {
    public static void main(String[] args) {
        try {
            Server server = new Server(8082);
            while(true) {
                server.receiveMessage();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class M1BaseballTest2 {
    public static void main(String[] args) {
        try {
            Server server = new Server(8083);
            while(true) {
                server.sendMessage(new CustomScanner("보낼문자").getFirstResponse()[0]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
class M1BaseBallTest3{
    public static void main(String[] args) {
        try {
            while(true){
                new Client("localhost", 8082).sendMessage(new CustomScanner("보낼문자").getFirstResponse()[0]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class M1BaseBallTest4{
    public static void main(String[] args) {
        try {
            while(true){
                new Client("localhost", 8083).receiveMessage();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}