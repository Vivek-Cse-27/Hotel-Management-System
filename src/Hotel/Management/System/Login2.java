package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login2 extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField t1;
    JPasswordField p1;
    Login2(){
        super("Hotel Management System - Admin Login");
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JLabel l1= new JLabel("Username");
        l1.setBounds(40,20,100,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        add(l1);
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Tahoma",Font.PLAIN,15));
        t1.setBackground(new Color(26,104,110));
        add(t1);
        JLabel l2= new JLabel("Password");
        l2.setBounds(40,70,100,30);
        l2.setFont(new Font("Tahoma",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        add(l2);
        p1=new JPasswordField();
        p1.setBounds(150,70,150,30);
        p1.setForeground(Color.WHITE);
        p1.setBackground(new Color(26,104,110));
        add(p1);
        ImageIcon img1= new ImageIcon(ClassLoader.getSystemResource("icon/Login.gif"));
        Image i1= img1.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        img1= new ImageIcon(i1);
        JLabel label=new JLabel(img1);
        label.setBounds(318,30,255,300);
        add(label);
        getContentPane().setBackground(new Color(3,45,48));
        b1=new JButton("Login");
        b1.setBounds(40,150,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        b2=new JButton("Cancel");
        b2.setBounds(180,150,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        setUndecorated(false);
        setLayout(null);
        setLocation(400,270);
        setSize(600, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1) {
           try{
            Connect c=new Connect();
            String user=t1.getText();
            String pass=p1.getText();
            String str="select * from admin where username='"+user+"' and password='"+pass+"'";
            ResultSet rs=c.statement.executeQuery(str);
            if(rs.next()){
                new Admin();
                setVisible(false);
           }
           else{
               JOptionPane.showMessageDialog(null, "Invalid username or password");
             }
            }
           catch(Exception ex){
               ex.printStackTrace();
        }
    } 
    else {
        new Dashboard();
        setVisible(false);
    }
    }

    public static void main(String[] args) {
        new Login2();
    }
}
