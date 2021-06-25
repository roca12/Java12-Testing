package Tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Puetto 2020 ha sido abierto");

        //Aceptando conexiones entrantes
        Socket socket = server_socket.accept();
        System.out.println("Cliente " + socket.getInetAddress() + " se ha conectado");

        //buffers e/s
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        
        //comunicacion
        out_socket.println("Bienvenido");
        String message =in_socket.readLine();
        System.out.println("El cliente dice: "+message);
        socket.close();
        System.out.println("Socket esta cerrado");
        
      

    }

    public static void main(String[] args) {

        try {
            new Server();
        } catch (Exception e) {
        }

    }

}
