import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
/**
 * it makes the appearance of the map of the game
 *
 * @author fatemeh
 * @version 1.0.0
 */
public class Graphic implements MouseListener {
    private JFrame mainFrame;
    private JPanel panel;
    private JPanel panel1;
    private static JPanel panel2;
    private JPanel panel3;
    private static JButton[][] bts;
    public static final Color VERY_LIGHT_RED = new Color(255,102,102);

    public Graphic() {
        mainFrame = new JFrame("Chess");
        panel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        bts = new JButton[8][8];

    }

    public void open() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBackground(Color.RED);
        panel3.setBackground(Color.GREEN);
        BorderLayout bLayout = new BorderLayout();
        mainFrame.getContentPane().add(panel);
        //mainFrame.setDefaultCloseOperation(1);
        panel.setLayout(bLayout);
        panel.add(panel1, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.CENTER);
        //panel.add(panel3,BorderLayout.EAST);
        panel1.setPreferredSize(new Dimension(350, 190));
        panel3.setPreferredSize(new Dimension(350, 190));
        panel2.setLayout(new GridLayout(8, 8));
        new Rook(3, "black", true, 7, 7);
        new Rook(4, "black", true, 0, 7);
        new Knight(3, "black", true, 1, 7);
        new Knight(4, "black", true, 6, 7);
        new Bishop(3, "black", true, 2, 7);
        new Bishop(4, "black", true, 5, 7);
        new King(2, "black", true, 4, 7);
        new Queen(2, "black", true, 3, 7);
        for (int i = 0; i < 8; i++) {
            new Pawn(i, "black", true, i, 6);
        }
        new Rook(1, "white", true, 0, 0);
        new Rook(2, "white", true, 7, 0);
        new Knight(1, "white", true, 1, 0);
        new Knight(2, "white", true, 6, 0);
        new Bishop(1, "white", true, 2, 0);
        new Bishop(2, "white", true, 5, 0);
        new King(1, "white", true, 4, 0);
        new Queen(1, "white", true, 3, 0);
        for (int i = 0; i < 8; i++) {
            new Pawn(i + 8, "white", true, i, 1);
        }
        for (Piece p : Piece.getPieces()) {
            if (p.color.equals("black")) {
                p.setIcon(new ImageIcon("" + p.getColor().toUpperCase().charAt(0) + p.getClass().getName() + ".png"));
                bts[p.getY()][p.getX()] = p;
            }
            if (p.color.equals("white")) {
                p.setIcon(new ImageIcon("" + p.getColor().toUpperCase().charAt(0) + p.getClass().getName() + ".png"));
                bts[p.getY()][p.getX()] = p;
            }
            p.addMouseListener(this);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (bts[i][j] == null) {
                    JButton btn = new JButton();
                    btn.addMouseListener(this);
                    bts[i][j] = btn;
                }
                if ((i + j) % 2 == 0) {
                    bts[i][j].setBackground(Color.white);
                } else {
                    bts[i][j].setBackground(Color.lightGray);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                panel2.add(bts[i][j]);
            }
        }
        panel2.repaint();
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void arrange() {
        panel2.removeAll();
        panel2.revalidate();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                panel2.add(bts[i][j]);
            }
        }
    }

    public void rearrange() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    bts[i][j].setBackground(Color.white);
                } else {
                    bts[i][j].setBackground(Color.lightGray);
                }
            }
        }
    }
    public String find(JButton[][] bts,JButton jbtn){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (bts[i][j] == jbtn){
                    return "" + i + j;
                }
            }
        }
        return null;
    }
    JButton btn2 = null;
    static boolean changed = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        if (!changed) {
            JButton jbtn = (JButton)e.getSource();
            if (jbtn instanceof Piece) {
                ((Piece) jbtn).availablePlaces(bts);
                for (String place : ((Piece) jbtn).places) {
                    int y = Integer.parseInt("" + place.charAt(0));
                    int x = Integer.parseInt("" + place.charAt(1));
                    bts[y][x].setBackground(Color.RED);
                }
                ((Piece) jbtn).availablePlaces(bts).removeAll(((Piece) jbtn).availablePlaces(bts));
                changed = true;
                arrange();
                btn2 = jbtn;
            }
        } else {
            JButton jbtn1 = (JButton)e.getSource();
            if (jbtn1.getBackground() == Color.RED) {
                int xDes = Integer.parseInt("" + find(bts,jbtn1).charAt(1));
                int yDes = Integer.parseInt("" + find(bts,jbtn1).charAt(0));
                int xOrig = Integer.parseInt("" + find(bts,btn2).charAt(1));
                int yOrig = Integer.parseInt("" + find(bts,btn2).charAt(0));
                bts[yDes][xDes] = btn2;
                ((Piece)btn2).setX(xDes);
                ((Piece)btn2).setY(yDes);
                if (jbtn1 instanceof Piece){
                    JButton newBtn = new JButton();
                    newBtn.addMouseListener(this);
                    bts[yOrig][xOrig] = newBtn;
                } else {
                    bts[yOrig][xOrig] = jbtn1;
                }

                arrange();
                rearrange();
            } else {
                rearrange();
            }
            changed = false;
        }
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
    }
}
