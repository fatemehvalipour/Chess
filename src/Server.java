import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket1;
    private Socket socket2;
    private ServerSocket server;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket1 = server.accept();
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new DataInputStream(socket1.getInputStream())));
            JButton[][] bts = (JButton[][]) in.readObject();
            System.out.println("Client1 accepted");

            socket2 = server.accept();
            System.out.println("Client2 accepted");
            ObjectOutputStream out = new ObjectOutputStream(new DataOutputStream(socket2.getOutputStream()));
            out.writeObject(bts);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            socket1.close();
            socket2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server(8080);
    }
}
