import javax.swing.*;
import java.awt.*;

public class Graphic {
    private JFrame mainFrame;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    public Graphic() {
        mainFrame = new JFrame("Chess");
        panel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

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
            //boolean color = false;
            for (int j = 0 ; j < 8  ;j++){
                // j % 2
                JButton btn = new JButton("" + j);
                panel2.add(btn,i,j);

            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
