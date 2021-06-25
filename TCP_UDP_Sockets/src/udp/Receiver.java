package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {

    public Receiver() throws Exception {
        DatagramSocket socket = new DatagramSocket(2020);
        System.out.println("Recibidor corriendo");

        while (true) {

            byte[] buffer = new byte[1500];//MTU
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String message = new String(buffer).trim();
            System.out.println("Recibido: " + message);

            InetAddress senders_addr = packet.getAddress();
            int senders_port = packet.getPort();
            message="OK";
            buffer = message.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, senders_addr, senders_port);
            socket.send(packet);
            System.out.println("Se envió : " + message);
        }
    }

    public static void main(String[] args) {
        try {
            new Receiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
