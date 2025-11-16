package Hotel.Management.System;
import net.proteanit.sql.DbUtils;

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
import javax.swing.JPanel;
import javax.swing.JTable;


public class Room extends JFrame{
    JTable table;
    JButton back;

    Room(){
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
    JPanel panel=new JPanel();
    panel.setLayout(null);
    panel.setBounds(5,5,1290,590);
    panel.setBackground(new Color(3,45,48));
    add(panel);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
    Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel l1=new JLabel(i3);
    l1.setBounds(950,200,200,200);
    panel.add(l1);

    table=new JTable();
    table.setBounds(0,80,850,400);
    table.setRowHeight(25);
    table.setBackground(new Color(3,45,48));
    table.setForeground(Color.white);
    table.setFont(new Font("Serif",Font.BOLD,20));
    table.setEnabled(false);
    panel.add(table);

    try {
    Connect c=new Connect();
    String str="select * from room";
    ResultSet rs=c.statement.executeQuery(str);
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
    } catch (Exception e) {
    e.printStackTrace();
    }
    back=new JButton("Back");
    back.setFont(new Font("Tahoma",Font.BOLD,28));
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(200,500,180,50);
    panel.add(back);
    back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    });

    JLabel room=new JLabel("Room No.");
    room.setBounds(10,55,100,20);
    room.setForeground(Color.WHITE);
    room.setFont(new Font("Tahoma",Font.BOLD,16));
    panel.add(room);

    JLabel available=new JLabel("Availability");
    available.setBounds(185,55,100,20);
    available.setForeground(Color.WHITE);
    available.setFont(new Font("Tahoma",Font.BOLD,16));
    panel.add(available);

    JLabel clean=new JLabel("Clean Status");
    clean.setBounds(525,55,150,20);
    clean.setForeground(Color.WHITE);
    clean.setFont(new Font("Tahoma",Font.BOLD,16));
    panel.add(clean);

    JLabel price=new JLabel("Price");
    price.setBounds(350,55,80,20);
    price.setForeground(Color.WHITE);
    price.setFont(new Font("Tahoma",Font.BOLD,16));
    panel.add(price);

    JLabel type=new JLabel("Bed Type");
    type.setBounds(692,55,80,20);
    type.setForeground(Color.WHITE);
    type.setFont(new Font("Tahoma",Font.BOLD,16));
    panel.add(type);

    setUndecorated(true);
    setLayout(null);
    setLocation(475,85);
    setSize(1300,600);
    setVisible(true);
    }
    public static void main(String[] args) {
        new Room();
    }
}
