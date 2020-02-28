package m1baseball;

import java.io.*;
import java.net.Socket;

public class Client {
    private final Socket socket;

    public Client(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public void sendMessage(String message) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(message);
        bw.flush();
        bw.close();
    }

    public void receiveMessage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = br.readLine();
        System.out.println(message);
    }
}
