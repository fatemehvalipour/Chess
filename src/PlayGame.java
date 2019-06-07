import java.io.IOException;

public class PlayGame {
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
