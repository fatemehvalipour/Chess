import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * it makes the appearance of the map of the game
 * @author man
 * @version 1.0
 */
public class Graphic implements MouseListener {
    private JFrame mainFrame;
    private JPanel panel;
    private JPanel panel1;
    private static JPanel panel2;
    private JPanel panel3;
    private static JButton[][] bts;

    public Graphic() {
        mainFrame = new JFrame("Chess");
        panel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        bts = new JButton[8][8];

    }
    public void open(){
        panel1.setBackground(Color.RED);
        panel3.setBackground(Color.GREEN);
        BorderLayout bLayout = new BorderLayout();
        mainFrame.getContentPane().add(panel);
        //mainFrame.setDefaultCloseOperation(1);
        panel.setLayout(bLayout);
        panel.add(panel1,BorderLayout.EAST);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(panel3,BorderLayout.WEST);
        panel1.setPreferredSize(new Dimension(350, 190));
        panel3.setPreferredSize(new Dimension(350, 190));
        panel2.setLayout(new GridLayout(8,8));
        new Rook(3,"black",true,7,7);
        new Rook(4,"black",true,0,7);
        new Knight(3,"black",true,1,7);
        new Knight(4,"black",true,6,7);
        new Bishop(3,"black",true,2,7);
        new Bishop(4,"black",true,5,7);
        new King(2,"black",true,4,7);
        new Queen(2,"black",true,3,7);
        for(int  i = 0 ; i < 8 ; i++){
            new Pawn(i,"black",true,i, 6);
        }
        new Rook(1,"white",true,0,0);
        new Rook(2,"white",true,7,0);
        new Knight(1,"white",true,1,0);
        new Knight(2,"white",true,6,0);
        new Bishop(1,"white",true,2,0);
        new Bishop(2,"white",true,5,0);
        new King(1,"white",true,4,0);
        new Queen(1,"white",true,3,0);
        for(int  i = 0 ; i < 8 ; i++){
            new Pawn(i+8,"white",true,i,1);
        }
        for (Piece p : Piece.getPieces()){
            if(p.color.equals("black")){
                p.setIcon(new ImageIcon("" + p.getColor().toUpperCase().charAt(0)+ p.getClass().getName() + ".png"));
               bts[p.getY()][p.getX()] = p;
            }
            if (p.color.equals("white")){
                p.setIcon(new ImageIcon("" +p.getColor().toUpperCase().charAt(0) + p.getClass().getName() + ".png"));
                bts[p.getY()][p.getX()] = p;
            }
            p.addMouseListener(this);
        }
        for(int i = 0 ; i < 8 ;i++){
            for (int j = 0 ; j < 8  ;j++){
                if (bts[i][j] == null){
                    JButton btn = new JButton();
                    bts[i][j] = btn;
                }
                if((i + j) % 2 == 0){
                    bts[i][j].setBackground(Color.white);
                }else {
                    bts[i][j].setBackground(Color.lightGray);
                }
            }
        }
        for (int i = 0 ; i < 8 ; i++){
            for ( int j = 0 ; j < 8 ;j++){
                panel2.add(bts[i][j]);
            }
        }
        panel2.repaint();
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    public void arrange(){
        panel2.removeAll();
        panel2.revalidate();
        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                panel2.add(bts[i][j]);
            }
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jbtn = (JButton)e.getSource();
        if (jbtn instanceof Piece) {
            ((Piece) jbtn).availablePlaces(bts);
            for (String place : ((Piece) jbtn).places) {
                int y = Integer.parseInt("" + place.charAt(0));
                int x = Integer.parseInt("" + place.charAt(1));
                bts[y][x].setBackground(Color.red);
            }
            arrange();
        }
//        if (jbtn instanceof Rook) {
//            ((Rook) jbtn).availablePlaces(bts);
//            for (String place : ((Rook) jbtn).places) {
//                int y = Integer.parseInt("" + place.charAt(0));
//                int x = Integer.parseInt("" + place.charAt(1));
//                bts[y][x].setBackground(Color.red);
//                System.out.println("" + place.charAt(0) + place.charAt(1));
////                System.out.println("" + i + " hala" + ((Rook) jbtn).places.get(i));
//            }
//            arrange();
//        }
//        if (jbtn instanceof Queen) {
//            ((Queen) jbtn).availablePlaces(bts);
//            for (String place : ((Queen) jbtn).places) {
//                int y = Integer.parseInt("" + place.charAt(0));
//                int x = Integer.parseInt("" + place.charAt(1));
//                bts[y][x].setBackground(Color.red);
////                System.out.println("" + i + " hala" + ((Rook) jbtn).places.get(i));
//            }
//            arrange();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        Graphic graphic = new Graphic();
        graphic.open();
        //r1.setIcon(new ImageIcon("rook.png"));
//        if(bts[1][3] instanceof Piece){
//            bts[1][2].setBackground(Color.blue);
//        }

    }
}
