package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {

    public Sender() throws Exception {
        while (true) {

            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            System.out.println("Escriba un mensaje");

            String message = sc.nextLine();
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 2020);

            socket.send(packet);
            System.out.println("Enviado: " + message);

            buffer = new byte[1500];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            message = new String(buffer).trim();
            System.out.println("Recibido: " + message);
        }
    }

    public static void main(String[] args) {
        try {
            new Sender();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
