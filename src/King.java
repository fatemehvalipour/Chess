public class King extends Piece {

    public King(int ID, String color, boolean isIn, int X, int Y) {
        super(ID , color, isIn, X, Y);
    }
    @Override
    boolean move(int x, int y) {
        if(Math.abs(y - super.Y)<= 1 &&  Math.abs(x - super.X) <= 1){
            if (!Ground.getWhatColor(x,y).equals(Ground.getWhatColor(X,Y))){
                return true;
            }
        }else {
            return false;
        }
        return false;
    }
}
