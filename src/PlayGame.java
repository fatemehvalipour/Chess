import java.io.IOException;
/**
 * Queen extends piece
 * @author Fatemeh Valipour
 * @version 1.0
 */
public class PlayGame {
    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
        Thread main = new Thread(server);
        main.start();
        Graphic whiteGraphic = new Graphic("white");
        Graphic blackGraphic = new Graphic("black");
        whiteGraphic.open();
        blackGraphic.open();
        Thread white = new Thread(whiteGraphic);
        Thread black = new Thread(blackGraphic);
        white.start();
        black.start();
    }
}
