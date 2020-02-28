package m1baseball;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void receiveMessage() throws IOException {
        Socket gameSocket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(gameSocket.getInputStream()));
        String message = br.readLine();
        System.out.println(message);
    }


    public void sendMessage(String message) throws IOException {
        Socket gameSocket = serverSocket.accept();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(gameSocket.getOutputStream()));
        bw.write(message);
        bw.flush();
        bw.close();
    }

}
