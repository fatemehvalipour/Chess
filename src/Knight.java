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
       if (!(bts[this.getY() - 2][this.getX() + 1] instanceof Piece)
               || !((Piece)bts[this.getY() - 2][this.getX() + 1]).getColor().equals(this.color)) {
           places.add("" + (this.getY() - 2) + (this.getX() + 1));

       }
        if (!(bts[this.getY() - 2][this.getX() - 1] instanceof Piece)
                || !((Piece)bts[this.getY() - 2][this.getX() - 1]).getColor().equals(this.color)) {
            places.add("" + (this.getY() - 2) + (this.getX() - 1));

        }
        if (!(bts[this.getY() + 2][this.getX() - 1] instanceof Piece)
                || !((Piece)bts[this.getY() + 2][this.getX() - 1]).getColor().equals(this.color)) {
            places.add("" + (this.getY() + 2) + (this.getX() - 1));
        }
        if (!(bts[this.getY() + 2][this.getX() + 1] instanceof Piece)
                || !((Piece)bts[this.getY() + 2][this.getX() + 1]).getColor().equals(this.color)) {
            places.add("" + (this.getY() + 2) + (this.getX() + 1));
        }
        if (!(bts[this.getY() - 1][this.getX() + 2] instanceof Piece)
                || !((Piece)bts[this.getY() - 1][this.getX() + 2]).getColor().equals(this.color)) {
            places.add("" + (this.getY() - 1) + (this.getX() + 2));
        }
        if (!(bts[this.getY() - 1][this.getX() - 2] instanceof Piece)
                || !((Piece)bts[this.getY() - 1][this.getX() - 2]).getColor().equals(this.color)) {
            places.add("" + (this.getY() - 1) + (this.getX() - 2));
        }
        if (!(bts[this.getY() + 1][this.getX() + 2] instanceof Piece)
                || !((Piece)bts[this.getY() + 1][this.getX() + 2]).getColor().equals(this.color)) {
            places.add("" + (this.getY() + 1) + (this.getX() + 2));
        }
        if (!(bts[this.getY() + 1][this.getX() - 2] instanceof Piece)
                || !((Piece)bts[this.getY() + 1][this.getX() - 2]).getColor().equals(this.color)) {
            places.add("" + (this.getY() + 1) + (this.getX() - 2));
        }
        return places;
    }

}
