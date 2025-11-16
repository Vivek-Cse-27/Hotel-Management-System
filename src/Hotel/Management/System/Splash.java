package Hotel.Management.System;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
public class Splash extends JFrame{
    Splash(){
        super("Vivek's Hotel Management System");
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/Loading1.gif"));
        Image i= img.getImage().getScaledInstance(858,680,Image.SCALE_DEFAULT);
        img= new ImageIcon(i);
        JLabel label= new JLabel(img);
        label.setBounds(0, 0, 858, 680);
        add(label);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setLocation(450,100);
        setSize(858,680);
        setVisible(true);
        try {
            Thread.sleep(5000); 
            new Login();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
}
}
 