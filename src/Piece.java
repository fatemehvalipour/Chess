import javax.swing.*;
import java.util.ArrayList;

/**
 * superclass of other pieces
 * @author man
 * @version 1.0
 */
//TODO bound check
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

    public int getMyY() {
        return Y;
    }

    public int getMyX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    protected ArrayList<String> Rook(JButton bts[][]){
        for (int i = this.getMyX() + 1; i < 8; i++) {
            if (!(bts[this.getMyY()][i] instanceof Piece)
                    || !(((Piece) bts[this.getMyY()][i]).getColor().equals(this.color))) {
                places.add("" + this.getMyY() + i);
                if (bts[this.getMyY()][i] instanceof Piece) {
                    if (!(((Piece) bts[this.getMyY()][i]).getColor().equals(this.color))) {
                        break;
                    }

                }
            } else {
                break;
            }
        }
        for (int i = this.getMyX() - 1; i >= 0; i--) {
            if (!(bts[this.getMyY()][i] instanceof Piece)
                    || !(((Piece) bts[this.getMyY()][i]).getColor().equals(this.color))) {
                places.add("" + this.getMyY() + i);
                if (bts[this.getMyY()][i] instanceof Piece) {
                    if (!(((Piece) bts[this.getMyY()][i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        for (int i = this.getMyY() + 1; i < 8; i++) {
            if (!(bts[i][this.getMyX()] instanceof Piece)
                    || !(((Piece) bts[i][this.getMyX()]).getColor().equals(this.color))) {
                System.out.println("" + this.getMyX() + ", " + i);
                places.add("" + i + this.getMyX());
                if (bts[i][this.getMyX()] instanceof Piece) {
                    if (!(((Piece) bts[i][this.getMyX()]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        for (int i = this.getMyY() - 1; i >= 0; i--) {
            if (!(bts[i][this.getMyX()] instanceof Piece)
                    || !(((Piece) bts[i][this.getMyX()]).getColor().equals(this.color))) {
                places.add("" + i + this.getMyX());
                if (bts[i][this.getMyX()] instanceof Piece) {
                    if (!(((Piece) bts[i][this.getMyX()]).getColor().equals(this.color))) {
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
        int min = Math.min(Math.abs(7 - this.getMyX()) , Math.abs(7 - this.getMyY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getMyY() + i][this.getMyX() + i] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() + i][this.getMyX() + i]).getColor().equals(this.color))){
                places.add("" + (this.getMyY() + i) + (this.getMyX() + i));
                if (bts[this.getMyY() + i][this.getMyX() + i] instanceof Piece) {
                    if (!(((Piece) bts[this.getMyY() + i][this.getMyX() + i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        min = Math.min(Math.abs(7 - this.getMyX()) , Math.abs(this.getMyY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getMyY() - i][this.getMyX() + i] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() - i][this.getMyX() + i]).getColor().equals(this.color))){
                places.add("" + (this.getMyY() - i) + (this.getMyX() + i));
                if (bts[this.getMyY() - i][this.getMyX() + i] instanceof Piece) {
                    if (!(((Piece) bts[this.getMyY() - i][this.getMyX() + i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        min = Math.min(Math.abs(this.getMyX()) , Math.abs(this.getMyY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getMyY() - i][this.getMyX() - i] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() - i][this.getMyX() - i]).getColor().equals(this.color))){
                places.add("" + (this.getMyY() - i) + (this.getMyX() - i));
                if (bts[this.getMyY() - i][this.getMyX() - i] instanceof Piece) {
                    if (!(((Piece) bts[this.getMyY() - i][this.getMyX() - i]).getColor().equals(this.color))) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        min = Math.min(Math.abs(this.getMyX()) , Math.abs( 7 - this.getMyY()));
        for (int i = 1 ;i < min + 1 ;i++){
            if (!(bts[this.getMyY() + i][this.getMyX() - i] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() + i][this.getMyX() - i]).getColor().equals(this.color))){
                places.add("" + (this.getMyY() + i) + (this.getMyX() - i));
                if (bts[this.getMyY() + i][this.getMyX() - i] instanceof Piece) {
                    if (!(((Piece) bts[this.getMyY() + i][this.getMyX() - i]).getColor().equals(this.color))) {
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
