public abstract class Piece {
    protected int ID;
    protected String color;
    protected boolean isIn;
    protected int X;
    protected int Y;

    abstract boolean move(int x, int y);

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
