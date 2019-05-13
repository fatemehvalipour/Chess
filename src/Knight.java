public class Knight extends Piece {

    public Knight(int ID , String color, boolean isIn, int X, int Y) {
        super(ID , color, isIn, X, Y);
    }
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
}
