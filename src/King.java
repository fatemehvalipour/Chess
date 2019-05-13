public class King extends Piece {

    public King(int ID, String color, boolean isIn, int X, int Y) {
        super(ID , color, isIn, X, Y);
    }
    @Override
    boolean move(int x, int y) {
        return false;
    }
}
