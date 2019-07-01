import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Server class
 * @author Fatemeh Valipour
 * @version 1.0
 */

public class Server implements Runnable {
    private Socket socket1;
    private Socket socket2;
    private DataInputStream in1;
    private DataOutputStream out1;
    private DataInputStream in2;
    private DataOutputStream out2;
    private ServerSocket server;
    private String turn;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            turn = "white";

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * method in thread to hear changes
     */
    @Override
    public void run() {
        try {
            System.out.println("server started");
            socket1 = server.accept();
            socket2 = server.accept();
            System.out.println("game server");
            in1 = new DataInputStream(socket1.getInputStream());
            out1 = new DataOutputStream(socket1.getOutputStream());
            in2 = new DataInputStream(socket2.getInputStream());
            out2 = new DataOutputStream(socket2.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            try {
                if (turn.equals("white")){
                    String strIn = in1.readUTF();
                    out2.writeUTF(strIn);
                    turn = "black";
                } else {
                    String strIn = in2.readUTF();
                    out1.writeUTF(strIn);
                    turn = "white";
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
