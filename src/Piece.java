import javax.swing.*;
import java.util.ArrayList;

/**
 * superclass of other pieces
 * @author man
 * @version 1.0
 */
public abstract class Piece extends JButton {
    protected int ID;
    protected String color;
    protected boolean isIn;
    protected int X;
    protected int Y;
    protected ArrayList<String> places;
    protected static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> getPieces() {
        return pieces;
    }
    abstract boolean moveing(int x, int y);
    abstract ArrayList<String> availablePlaces(JButton[][] bts);
    //TODO check if x , y are ok in the table
    public Piece(int ID, String color, boolean isIn, int X, int Y) {
        this.ID = ID;
        this.color = color;
        this.isIn = isIn;
        this.Y = Y;
        this.X = X;
        places = new ArrayList<>();
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
    protected ArrayList<String> Rook(JButton bts[][]){
        for (int i = this.getX() + 1; i < 8; i++) {
            if (!(bts[this.getY()][i] instanceof Piece)
                    || !(((Piece) bts[this.getY()][i]).getColor().equals(this.color))) {
                places.add("" + this.getY() + i);
                if (bts[this.getY()][i] instanceof Piece) {
                    if (!(((Piece) bts[this.getY()][i]).getColor().equals(this.color))) {
                        break;
                    }

                }
            } else {
                break;
            }
        }
        for (int i = this.getX() - 1; i >= 0; i--) {
            if (!(bts[this.getY()][i] instanceof Piece)
                    || !(((Piece) bts[this.getY()][i]).getColor().equals(this.color))) {
                places.add("" + this.getY() + i);
                if (bts[this.getY()][i] instanceof Piece) {
                    if (!(((Piece) bts[this.getY()][i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        for (int i = this.getY() + 1; i < 8; i++) {
            if (!(bts[i][this.getX()] instanceof Piece)
                    || !(((Piece) bts[i][this.getX()]).getColor().equals(this.color))) {
                System.out.println("" + this.getX() + ", " + i);
                places.add("" + i + this.getX());
                if (bts[i][this.getX()] instanceof Piece) {
                    if (!(((Piece) bts[i][this.getX()]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        for (int i = this.getY() - 1; i >= 0; i--) {
            if (!(bts[i][this.getX()] instanceof Piece)
                    || !(((Piece) bts[i][this.getX()]).getColor().equals(this.color))) {
                places.add("" + i + this.getX());
                if (bts[i][this.getX()] instanceof Piece) {
                    if (!(((Piece) bts[i][this.getX()]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return places;
    }
    protected ArrayList<String> Bishop(JButton bts[][]){
        int min = Math.min(Math.abs(7 - this.getX()) , Math.abs(7 - this.getY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getY() + i][this.getX() + i] instanceof Piece)
                    || !(((Piece) bts[this.getY() + i][this.getX() + i]).getColor().equals(this.color))){
                places.add("" + (this.getY() + i) + (this.getX() + i));
                if (bts[this.getY() + i][this.getX() + i] instanceof Piece) {
                    if (!(((Piece) bts[this.getY() + i][this.getX() + i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        min = Math.min(Math.abs(7 - this.getX()) , Math.abs(this.getY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getY() - i][this.getX() + i] instanceof Piece)
                    || !(((Piece) bts[this.getY() - i][this.getX() + i]).getColor().equals(this.color))){
                places.add("" + (this.getY() - i) + (this.getX() + i));
                if (bts[this.getY() - i][this.getX() + i] instanceof Piece) {
                    if (!(((Piece) bts[this.getY() - i][this.getX() + i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        min = Math.min(Math.abs(this.getX()) , Math.abs(this.getY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getY() - i][this.getX() - i] instanceof Piece)
                    || !(((Piece) bts[this.getY() - i][this.getX() - i]).getColor().equals(this.color))){
                places.add("" + (this.getY() - i) + (this.getX() - i));
                if (bts[this.getY() - i][this.getX() - i] instanceof Piece) {
                    if (!(((Piece) bts[this.getY() - i][this.getX() - i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        min = Math.min(Math.abs(this.getX()) , Math.abs( 7 - this.getY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getY() + i][this.getX() - i] instanceof Piece)
                    || !(((Piece) bts[this.getY() + i][this.getX() - i]).getColor().equals(this.color))){
                places.add("" + (this.getY() + i) + (this.getX() - i));
                if (bts[this.getY() + i][this.getX() - i] instanceof Piece) {
                    if (!(((Piece) bts[this.getY() + i][this.getX() - i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return places;
    }

}
