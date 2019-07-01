import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * shows King features and extends piece
 * @author Fatemeh Valipour
 * @version 1.0
 */
public class King extends Piece {

    public King(int ID, String color, boolean isIn, int X, int Y) {
        super(ID , color, isIn, X, Y);
        pieces.add(this);
    }
//    /**
//     * checks possibility of move
//     * @param x destination
//     * @param y destination
//     * @return a boolean to demonstrate if Bishop is movable or not
//     */
    /*boolean moveing(int x, int y) {
        if(Math.abs(y - super.Y)<= 1 &&  Math.abs(x - super.X) <= 1){
            if (!Ground.getWhatColor(x,y).equals(Ground.getWhatColor(X,Y))){
                return true;
            }
        }else {
            return false;
        }
        return false;
    }*/

    /**
     *
     * @param bts 2D array,the map
     * @return Arraylist of available places to move
     */
    @Override
    ArrayList<String> availablePlaces(JButton[][] bts) {
        if (this.getMyY() <= 6 && this.getMyX() >= 1) {
            if (!(bts[this.getMyY() + 1][this.getMyX() - 1] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() + 1][this.getMyX() - 1]).getColor().equals(this.color))) {
                places.add("" + (this.getMyY() + 1) + (this.getMyX() - 1));
            }
        }
        if (this.getMyY() <= 6) {
            if (!(bts[this.getMyY() + 1][this.getMyX()] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() + 1][this.getMyX()]).getColor().equals(this.color))) {
                places.add("" + (this.getMyY() + 1) + (this.getMyX()));
            }
        }
        if (this.getMyY() <= 6 && this.getMyX() <= 6) {
            if (!(bts[this.getMyY() + 1][this.getMyX() + 1] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() + 1][this.getMyX() + 1]).getColor().equals(this.color))) {
                places.add("" + (this.getMyY() + 1) + (this.getMyX() + 1));
            }
        }
        if (this.getMyY() >= 1 && this.getMyX() >= 1) {
            if (!(bts[this.getMyY() - 1][this.getMyX() - 1] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() - 1][this.getMyX() - 1]).getColor().equals(this.color))) {
                places.add("" + (this.getMyY() - 1) + (this.getMyX() - 1));
            }
        }
        if (this.getMyY() >= 1 && this.getMyX() <= 6) {
            if (!(bts[this.getMyY() - 1][this.getMyX() + 1] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() - 1][this.getMyX() + 1]).getColor().equals(this.color))) {
                places.add("" + (this.getMyY() - 1) + (this.getMyX() + 1));
            }
        }
        if (this.getMyY() >= 1) {
            if (!(bts[this.getMyY() - 1][this.getMyX()] instanceof Piece)
                    || !(((Piece) bts[this.getMyY() - 1][this.getMyX()]).getColor().equals(this.color))) {
                places.add("" + (this.getMyY() - 1) + this.getMyX());
            }
        }
        if (this.getMyX() >= 1) {
            if (!(bts[this.getMyY()][this.getMyX() - 1] instanceof Piece)
                    || !(((Piece) bts[this.getMyY()][this.getMyX() - 1]).getColor().equals(this.color))) {
                places.add("" + this.getMyY() + (this.getMyX() - 1));
            }
        }
        if (this.getMyX() <= 6) {
            if (!(bts[this.getMyY()][this.getMyX() + 1] instanceof Piece)
                    || !(((Piece) bts[this.getMyY()][this.getMyX() + 1]).getColor().equals(this.color))) {
                places.add("" + this.getMyY() + (this.getMyX() + 1));
            }
        }
        return places;
    }
}
