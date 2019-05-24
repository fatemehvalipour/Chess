/**
 * the map
 * @author man
 * @version 1.0
 */
public class Ground {
    static String[][] game;

    public Ground() {
        game = new String[8][8];
    }
    public static String getWhatColor(int x,int y){
        return game[x][y];
    }

    public void setGame(int x,int y,String kind) {
        game[x][y] = kind;
    }

    /*public String[][] getGame() {
        return game;
    }*/

    public void setGame(){
        for(int i = 0 ; i < 8 ;i++){
            for(int j = 0 ; j < 8 ;j++){
                setGame(i,j,"-");
            }
        }
    }

    public void print(){
        int k = 8;
        System.out.println("  a "+"b "+"c "+"d "+"e "+"f "+"g "+"h ");
        for (int i = 0 ; i < 8 ; i++){
            System.out.print(k);
            for(int j = 0 ; j < 8 ; j++){
                System.out.print("|_");
            }
            System.out.println("|");
            k--;
        }
    }
}
