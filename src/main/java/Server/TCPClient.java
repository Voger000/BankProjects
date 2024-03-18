package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args)  {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Enter a message to send to the server: ");
            String message;
            while (true) {
                Scanner scanner = new Scanner(System.in);
                message = scanner.nextLine();
                out.println(message);
                if (message.equals("exit")) {
                    out.println("Client disconnected");
                    break;
                }
            }

            String response = in.readLine();
            System.out.println("Server response: " + response);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}