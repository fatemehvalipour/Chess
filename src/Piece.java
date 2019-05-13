import javax.swing.*;

public abstract class Piece extends JButton {
    protected int ID;
    protected String color;
    protected boolean isIn;
    protected int X;
    protected int Y;

    abstract boolean moveing(int x, int y);
    //TODO check if x , y are ok in the table
    public Piece(int ID, String color, boolean isIn, int X, int Y) {
        this.ID = ID;
        this.color = color;
        this.isIn = isIn;
        this.Y = Y;
        this.X = X;
    }

    public String getColor() {
        return color;
    }

    public boolean isIn() {
        return isIn;
    }

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }
}
