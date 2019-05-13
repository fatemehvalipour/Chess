public class Rook extends Piece {

    public Rook(int ID , String color, boolean isIn, int X, int Y) {
        super(ID,color, isIn, X, Y);
    }

    @Override
    boolean moveing(int x, int y) {
        boolean movable = false;
        if((x == super.X && y != super.Y) || (y == super.Y && x != super.X) ){
            movable = true;
        }else{
            return false;
        }
        if(movable && !Ground.getWhatColor(x,y).equals(color)){
            if (x == super.X && y != super.Y){
                boolean YesOrNo = false;
                int dif = Math.abs(y - super.Y);
                int ratio = 1;
                if(y - super.Y < 0){
                    ratio = -1;
                }
                for(int i = 1; i <= dif ; i++){
                    if(Ground.game[x][super.Y + (ratio * i)].equals("-")){
                        YesOrNo = true;
                    }else{
                        YesOrNo = false;
                        break;
                    }
                }
                if(YesOrNo){
                    return true;
                }else
                    return false;
            }
            else if (x != X && y == Y){//TODO why always true?
                boolean YesOrNo = false;
                int dif = Math.abs(x - super.X);
                int ratio = 1;
                if(x - super.X < 0){
                    ratio = -1;
                }
                for(int i = 1; i <= dif ; i++){
                    if(Ground.game[super.X + (ratio * i)][y].equals("-")){
                        YesOrNo = true;
                    }else{
                        YesOrNo = false;
                        break;
                    }
                }
                if(YesOrNo){
                    return true;
                }else
                    return false;
            }
        }else {
            return false;
        }
        return false;
    }

}
