package Hotel.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dashboard extends JFrame implements ActionListener {
    JButton add,rec;
    Dashboard(){
        super("HOTEL MANAGEMENT SYSTEM");
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        rec=new JButton("RECEPTION");
        rec.setBounds(620,700,180,40);
        rec.setFont(new Font("Tahoma",Font.BOLD,20));
        rec.setBackground(new Color(255,98,0)); 
        rec.setForeground(Color.WHITE);  
        rec.addActionListener(this);
        add(rec);

        add=new JButton("ADMIN");
        add.setBounds(1150,700,180,40);
        add.setFont(new Font("Tahoma",Font.BOLD,20));
        add.setBackground(new Color(255,98,0)); 
        add.setForeground(Color.WHITE); 
        add.addActionListener(this);
        add(add);

        ImageIcon boss=new ImageIcon(ClassLoader.getSystemResource("icon/admin.png"));
        Image boss1=boss.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon boss2=new ImageIcon(boss1);
        JLabel label2=new JLabel(boss2);
        label2.setBounds(1140,490,200,195);
        add(label2);

        ImageIcon recep=new ImageIcon(ClassLoader.getSystemResource("icon/Reception2.png"));
        Image recep1=recep.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon recep2=new ImageIcon(recep1);
        JLabel label3=new JLabel(recep2);
        label3.setBounds(610,490,200,195);
        add(label3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image img=i1.getImage().getScaledInstance(1930, 1200, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,1930,1200);
        add(image);
        setLayout(null);
        setSize(1930,1200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            new Reception();
            setVisible(false);
        }
        else{
            new Login2();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}
