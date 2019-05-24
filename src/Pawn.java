import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Pawn extends piece
 * @author man
 * @version 1.0
 */
public class Pawn extends Piece {
    private boolean firstMove;
    public Pawn(int ID,String color, boolean isIn, int X, int Y) {
        super(ID,color, isIn, X, Y);
        firstMove = true;
        pieces.add(this);
    }

    //TODO after first move change the boolean to false in main

    public boolean isFirstMove() {
        return firstMove;
    }

    /**
     * sets a boolean if it is first move or not
     * @param firstMove
     */
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    /**
     *
     * @param x destination
     * @param y destination
     * @return boolean to check if pawn is movable or not
     */
    @Override
    boolean moveing(int x,int y) {
        boolean movable = false;
        if (firstMove && (x == X && (Math.abs(y - Y )== 2 || Math.abs(y - Y )== 1))){
            movable = true;
        }else if(!firstMove && x == X && Math.abs(y - Y) == 1){
            movable = true;
        }else {
            return false;
        }
        boolean yesOrNo = false;
        if (movable && !Ground.getWhatColor(x,y).equals(Ground.getWhatColor(X,Y))){
            int dif = Math.abs(y - super.Y);
            int ratio = 1;
            if(y - super.Y < 0){
                ratio = -1;
            }
            for(int i = 1;i < dif ;i++){
                if(Ground.game[x][super.Y + ratio * i].equals("-")){
                    yesOrNo = true;
                }else {
                    yesOrNo = false;
                    break;
                }
            }
            if (yesOrNo){
                return true;
            }else
                return false;
        }
        return false;
    }

    @Override
    ArrayList<String> availablePlaces(JButton[][] bts) {
        if (this.getColor().equals("black")) {
            if (this.getY() == 6) {
                if (!(bts[this.getY() - 1][this.getX()] instanceof Piece)) {
                    places.add("" + (this.getY() - 1) + (this.getX()));
                    if (!(bts[this.getY() - 2][this.getX()] instanceof Piece)) {
                        places.add("" + (this.getY() - 2) + (this.getX()));
                    }
                }
            } else {
                if (this.getY() >= 1) {
                    if (!(bts[this.getY() - 1][this.getX()] instanceof Piece)) {
                        places.add("" + (this.getY() - 1) + (this.getX()));
                    }
                }
                if (this.getY() >= 1 && this.getX() <= 6) {
                    if (bts[this.getY() - 1][this.getX() + 1] instanceof Piece && ((Piece) bts[this.getY() - 1][this.getX() + 1]).getColor().equals("white")) {
                        places.add("" + (this.getY() - 1) + (this.getX() + 1));
                    }
                }
                if (this.getY() >= 1 && this.getX() >= 1) {
                    if (bts[this.getY() - 1][this.getX() - 1] instanceof Piece && ((Piece) bts[this.getY() - 1][this.getX() - 1]).getColor().equals("white")) {
                        places.add("" + (this.getY() - 1) + (this.getX() - 1));
                    }
                }

            }
        } else {
            if (this.getY() == 1) {
                if (!(bts[this.getY() + 1][this.getX()] instanceof Piece)) {
                    places.add("" + (this.getY() + 1) + (this.getX()));
                    if (!(bts[this.getY() + 2][this.getX()] instanceof Piece)) {
                        places.add("" + (this.getY() + 2) + (this.getX()));
                    }
                }
            } else {
                if (this.getY() <= 6) {
                    if (!(bts[this.getY() + 1][this.getX()] instanceof Piece)) {
                        places.add("" + (this.getY() + 1) + (this.getX()));
                    }
                }
                if (this.getY() <= 6 && this.getX() <= 6) {
                    if (bts[this.getY() + 1][this.getX() + 1] instanceof Piece && ((Piece) bts[this.getY() + 1][this.getX() + 1]).getColor().equals("black")) {
                        places.add("" + (this.getY() + 1) + (this.getX() + 1));
                    }
                }
                if (this.getY() <= 6 && this.getX() >= 1) {
                    if (bts[this.getY() + 1][this.getX() - 1] instanceof Piece && ((Piece) bts[this.getY() + 1][this.getX() - 1]).getColor().equals("black")) {
                        places.add("" + (this.getY() + 1) + (this.getX() - 1));
                    }
                }

            }
        }
            return places;
        }


}
