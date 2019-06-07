import javax.swing.*;
import java.util.ArrayList;

/**
 * Knight extends piece
 * @author man
 * @version 1.0
 */
public class Knight extends Piece {

    public Knight(int ID , String color, boolean isIn, int X, int Y) {
        super(ID , color, isIn, X, Y);
        pieces.add(this);
    }
    /**
     * checks possibility of move
     * @param x destination
     * @param y destination
     * @return a boolean to demonstrate if Bishop is movable or not
     */
    @Override
    boolean moveing(int x, int y) {
        boolean movable;
        if(Math.abs(x - super.X) + Math.abs(y - super.Y) == 3 && Math.abs(x - super.X) <= 2 && Math.abs(y - super.Y) <= 2 ){
            movable = true;
        }else {
            return false;
        }
        if (movable && !Ground.getWhatColor(x,y).equals(Ground.getWhatColor(X,Y))){
            return true;
        }
        return false;
    }

    @Override
    ArrayList<String> availablePlaces(JButton[][] bts) {
        if (this.getMyY() >= 2 && this.getMyX() <= 6) {
            if (!(bts[this.getMyY() - 2][this.getMyX() + 1] instanceof Piece)
                    || !((Piece) bts[this.getMyY() - 2][this.getMyX() + 1]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() - 2) + (this.getMyX() + 1));

            }
        }
        if (this.getMyY() >= 2 && this.getMyX() >= 1) {
            if (!(bts[this.getMyY() - 2][this.getMyX() - 1] instanceof Piece)
                    || !((Piece) bts[this.getMyY() - 2][this.getMyX() - 1]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() - 2) + (this.getMyX() - 1));

            }
        }
        if (this.getMyX() >= 1 && this.getMyY() <= 5) {
            if (!(bts[this.getMyY() + 2][this.getMyX() - 1] instanceof Piece)
                    || !((Piece) bts[this.getMyY() + 2][this.getMyX() - 1]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() + 2) + (this.getMyX() - 1));
            }
        }
        if (this.getMyY() <= 5 &&  this.getMyX() <= 6) {
            if (!(bts[this.getMyY() + 2][this.getMyX() + 1] instanceof Piece)
                    || !((Piece) bts[this.getMyY() + 2][this.getMyX() + 1]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() + 2) + (this.getMyX() + 1));
            }
        }
        if (this.getMyX() <= 5 && this.getMyY() >= 1) {
            if (!(bts[this.getMyY() - 1][this.getMyX() + 2] instanceof Piece)
                    || !((Piece) bts[this.getMyY() - 1][this.getMyX() + 2]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() - 1) + (this.getMyX() + 2));
            }
        }
        if (this.getMyY() >= 1 && this.getMyX() >= 2) {
            if (!(bts[this.getMyY() - 1][this.getMyX() - 2] instanceof Piece)
                    || !((Piece) bts[this.getMyY() - 1][this.getMyX() - 2]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() - 1) + (this.getMyX() - 2));
            }
        }
        if (this.getMyY() <= 6 && this.getMyX() <= 5) {
            if (!(bts[this.getMyY() + 1][this.getMyX() + 2] instanceof Piece)
                    || !((Piece) bts[this.getMyY() + 1][this.getMyX() + 2]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() + 1) + (this.getMyX() + 2));
            }
        }
        if (this.getMyY() <= 6 && this.getMyX() >= 2) {
            if (!(bts[this.getMyY() + 1][this.getMyX() - 2] instanceof Piece)
                    || !((Piece) bts[this.getMyY() + 1][this.getMyX() - 2]).getColor().equals(this.color)) {
                places.add("" + (this.getMyY() + 1) + (this.getMyX() - 2));
            }
        }
        return places;
    }

}
