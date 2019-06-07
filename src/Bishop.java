import javax.swing.*;
import java.util.ArrayList;

/**
 * Bishop extends piece
 * @author man
 * @version 1.0
 */
public class Bishop extends Piece {
    public Bishop(int ID, String color, boolean isIn, int X, int Y) {
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
        boolean movable = false;
        if (Math.abs(x - super.X) == Math.abs(y - super.Y)){
            movable = true;
        }else {
            return false;
        }
        if (movable && !Ground.getWhatColor(x,y).equals(Ground.getWhatColor(X,Y))){
            if (x - super.X == y - super.Y) {
                int dif = x - super.X;
                int ratio = 1;
                if (x - super.X < 0){
                    ratio = -1;
                }
                boolean yesOrNo = false;
                for (int  i = 1 ; i < dif; i++){
                    if (Ground.game[super.X + (i * ratio)][super.Y + (i * ratio)].equals("-")) {
                        yesOrNo = true;
                    } else {
                        yesOrNo = false;
                        break;
                    }
                }
                if(yesOrNo){
                    return true;
                }else
                    return false;

            }
            else if (x - super.X == (-1) * (y - super.Y)) {
                int ratioX = 1;
                int ratioY = 1;
                if (x - super.X < 0){
                    ratioX = -1;
                }
                if (y - super.Y < 0){
                    ratioY = -1;
                }
                int dif = Math.abs(x - super.X);
                boolean yesOrNo = false;
                for (int  i = 1 ; i < dif; i++){
                    if (Ground.game[super.X + i * ratioX][super.Y + i * ratioY].equals("-")) {
                        yesOrNo = true;
                    } else {
                        yesOrNo = false;
                        break;
                    }
                }
                if(yesOrNo){
                    return true;
                }else
                    return false;
                }
        }else {
            return false;
        }
        return false;
    }

    @Override
    ArrayList<String> availablePlaces(JButton[][] bts) {
        places = Bishop(bts);
        return places;
    }
}
