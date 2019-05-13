import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Graphic implements MouseListener {
    private JFrame mainFrame;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton[][] bts;

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
        panel2.setBackground(Color.orange);
        panel3.setBackground(Color.GREEN);
        BorderLayout bLayout = new BorderLayout();
        mainFrame.getContentPane().add(panel);
        panel.setLayout(bLayout);
        panel.add(panel1,BorderLayout.EAST);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(panel3,BorderLayout.WEST);
        panel1.setPreferredSize(new Dimension(350, 190));
        panel3.setPreferredSize(new Dimension(350, 190));
        panel2.setLayout(new GridLayout(8,8));
        for(int i = 0 ; i < 8 ;i++){
            for (int j = 0 ; j < 8  ;j++){
                JButton btn = new JButton("" + j);
                bts[i][j] = btn;
                panel2.add(btn,i,j);
            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        Rook r1 = new Rook(1,"white",true,0,7);
        Rook r2 = new Rook(2,"white",true,7,0);
        Knight kn1 = new Knight(1,"white",true,1,0);
        Knight kn2 = new Knight(2,"white",true,6,0);
        Bishop b1 = new Bishop(1,"white",true,2,0);
        Bishop b2 = new Bishop(2,"white",true,5,0);
        for(int  i = 0 ; i < 8 ; i++){
            Pawn p = new Pawn(i,"white",true,i,1);
        }
        Rook r3 = new Rook(3,"black",true,0,0);
        Rook r4 = new Rook(4,"black",true,7,0);
        Knight kn3 = new Knight(3,"black",true,1,0);
        Knight kn4 = new Knight(4,"black",true,6,0);
        Bishop b3 = new Bishop(3,"black",true,2,0);
        Bishop b4 = new Bishop(4,"black",true,5,0);
        for(int  i = 0 ; i < 8 ; i++){
            Pawn p = new Pawn(i,"black",true,i,1);
        }

    }
}
