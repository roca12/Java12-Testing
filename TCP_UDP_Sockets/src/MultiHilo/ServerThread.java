package MultiHilo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    private Server server;

    public ServerThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            int client_number = server.getClientNumber();
            System.out.println("Cliente "+client_number+" se ha conectado");

            //buffers e/s
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            //comunicacion
            out_socket.println("Bienvenido");
            String message = in_socket.readLine();
            System.out.println("El cliente dice: " + message);
            socket.close();
            System.out.println("Cliente "+client_number+" se ha desconectado");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
