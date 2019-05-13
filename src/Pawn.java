public class Pawn extends Piece {
    boolean firstMove;
    public Pawn(int ID,String color, boolean isIn, int X, int Y) {
        super(ID,color, isIn, X, Y);
        firstMove = true;
    }
    //TODO after first move change the boolean to false in main

    @Override
    boolean move(int x,int y) {
        boolean movable = false;
        if (firstMove && (x == X && (y - Y == 2 || y - Y == 1))){
            movable = true;
        }else if(!firstMove && x == X && y - Y == 1){
            movable = true;
        }else {
            return false;
        }
        boolean yesOrNo = false;
        if (movable && !Ground.getWhatColor(x,y).equals(Ground.getWhatColor(X,Y))){
            int dif = y - super.Y;
            for(int i = 1;i < dif ;i++){
                if(Ground.game[x][super.Y + i].equals("-")){
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

}
