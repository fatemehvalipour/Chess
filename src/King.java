import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * King extends piece
 * @author man
 * @version 1.0
 */
public class King extends Piece {

    public King(int ID, String color, boolean isIn, int X, int Y) {
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
        if(Math.abs(y - super.Y)<= 1 &&  Math.abs(x - super.X) <= 1){
            if (!Ground.getWhatColor(x,y).equals(Ground.getWhatColor(X,Y))){
                return true;
            }
        }else {
            return false;
        }
        return false;
    }

    @Override
    ArrayList<String> availablePlaces(JButton[][] bts) {
        if (!(bts[this.getY() + 1][this.getX() - 1] instanceof Piece)
                || !(((Piece) bts[this.getY() + 1][this.getX() - 1]).getColor().equals(this.color))){
            places.add("" + (this.getY() + 1 ) + (this.getX() - 1));
        }
        if (!(bts[this.getY() + 1][this.getX()] instanceof Piece)
                || !(((Piece) bts[this.getY() + 1][this.getX()]).getColor().equals(this.color))){
            places.add("" + (this.getY() + 1) + (this.getX()));
        }
        if (!(bts[this.getY() + 1][this.getX() + 1] instanceof Piece)
                || !(((Piece) bts[this.getY() + 1][this.getX() + 1]).getColor().equals(this.color))){
            places.add("" + (this.getY() + 1) + (this.getX() + 1));
        }
        if (!(bts[this.getY() - 1][this.getX() - 1] instanceof Piece)
                || !(((Piece) bts[this.getY() - 1][this.getX() - 1]).getColor().equals(this.color))){
            places.add("" + (this.getY() - 1) + (this.getX() - 1));
        }
        if (!(bts[this.getY() - 1][this.getX() + 1] instanceof Piece)
                || !(((Piece) bts[this.getY() - 1][this.getX() + 1]).getColor().equals(this.color))){
            places.add("" + (this.getY() - 1) + (this.getX() + 1));
        }
        if (!(bts[this.getY() - 1][this.getX()] instanceof Piece)
                || !(((Piece) bts[this.getY() - 1][this.getX()]).getColor().equals(this.color))){
            places.add("" + (this.getY() - 1) + this.getX());
        }
        if (!(bts[this.getY()][this.getX() - 1] instanceof Piece)
                || !(((Piece) bts[this.getY()][this.getX() - 1]).getColor().equals(this.color))){
            places.add("" + this.getY() + (this.getX() - 1));
        }
        if (!(bts[this.getY()][this.getX() + 1] instanceof Piece)
                || !(((Piece) bts[this.getY()][this.getX() + 1]).getColor().equals(this.color))){
            places.add("" + this.getY() + (this.getX() + 1));
        }
        return places;
    }
}
