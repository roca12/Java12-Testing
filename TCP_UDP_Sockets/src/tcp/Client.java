package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client() throws Exception{
        Socket socket = new Socket("localhost",2020);
        System.out.println("Conexión establecida con el servidor");
        
             //buffers e/s
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        
        String message=in_socket.readLine();
        System.out.println("El servidor dice: "+message);
        out_socket.println("Gracias");
        
        
        socket.close();
        System.out.println("El socket se ha cerrado");
    }
    
    

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
