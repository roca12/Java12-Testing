package MultiHilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Puerto 2020 esta abierto");

        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket,this);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }
    private int clientnumber=1;
    
    public int getClientNumber(){
        return clientnumber++;
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
