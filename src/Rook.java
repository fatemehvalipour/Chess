import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Rook extends piece
 *
 * @author man
 * @version 1.0
 */
public class Rook extends Piece {

    public Rook(int ID, String color, boolean isIn, int X, int Y) {
        super(ID, color, isIn, X, Y);
        pieces.add(this);
    }

    /**
     * checks possibility of move
     *
     * @param x destination
     * @param y destination
     * @return a boolean to demonstrate if Bishop is movable or not
     */
    @Override
    boolean moveing(int x, int y) {
        if ((x == super.X && y != super.Y) || (y == super.Y && x != super.X)) {

            if (!Ground.getWhatColor(x, y).equals(color)) {
                if (x == super.X && y != super.Y) {
                    boolean YesOrNo = false;
                    int dif = Math.abs(y - super.Y);
                    int ratio = 1;
                    if (y - super.Y < 0) {
                        ratio = -1;
                    }
                    for (int i = 1; i <= dif; i++) {
                        if (Ground.game[x][super.Y + (ratio * i)].equals("-")) {
                            YesOrNo = true;
                        } else {
                            YesOrNo = false;
                            break;
                        }
                    }
                    if (YesOrNo) {
                        return true;
                    } else
                        return false;
                } else if (x != X && y == Y) {//TODO why always true?
                    boolean YesOrNo = false;
                    int dif = Math.abs(x - super.X);
                    int ratio = 1;
                    if (x - super.X < 0) {
                        ratio = -1;
                    }
                    for (int i = 1; i <= dif; i++) {
                        if (Ground.game[super.X + (ratio * i)][y].equals("-")) {
                            YesOrNo = true;
                        } else {
                            YesOrNo = false;
                            break;
                        }
                    }
                    if (YesOrNo) {
                        return true;
                    } else
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    ArrayList<String> availablePlaces(JButton[][] bts) {
        places = Rook(bts);
        return places;
    }

}
