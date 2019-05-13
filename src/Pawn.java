public class Pawn extends Piece {
    private boolean firstMove;
    public Pawn(int ID,String color, boolean isIn, int X, int Y) {
        super(ID,color, isIn, X, Y);
        firstMove = true;
    }
    //TODO after first move change the boolean to false in main

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    boolean move(int x,int y) {
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

}
