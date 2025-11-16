package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener{
   
    JButton add_emp, add_room, add_drivers,Logout,Back;
   
    Admin(){
        super("HOTEL ADMIN");
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());

        add_emp=new JButton("Add Employee");
        add_emp.setBounds(250,215,200,30);
        add_emp.setBackground(Color.white);
        add_emp.setForeground(Color.black);
        add_emp.setFont(new Font("Tahoma",Font.BOLD,20));
        add_emp.addActionListener(this);
        add(add_emp);

        add_room=new JButton("Add Room");
        add_room.setBounds(250,415,200,30);
        add_room.setBackground(Color.white);
        add_room.setForeground(Color.black);
        add_room.setFont(new Font("Tahoma",Font.BOLD,20));
        add_room.addActionListener(this);
        add(add_room);

        add_drivers=new JButton("Add Drivers");
        add_drivers.setBounds(250,615,200,30);
        add_drivers.setBackground(Color.white);
        add_drivers.setForeground(Color.black);
        add_drivers.setFont(new Font("Tahoma",Font.BOLD,20));
        add_drivers.addActionListener(this);
        add(add_drivers);

        Logout=new JButton("Logout");
        Logout.setBounds(50,1000,120,30);
        Logout.setBackground(Color.black);
        Logout.setForeground(Color.white);
        Logout.setFont(new Font("Tahoma",Font.BOLD,20));
        Logout.addActionListener(this);
        add(Logout);

        Back=new JButton("Back");
        Back.setBounds(200,1000,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.setFont(new Font("Tahoma",Font.BOLD,20));
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image i2=i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(70,100,150,150);
        add(l1);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/room1.png"));
        Image i22=i11.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel l11=new JLabel(i33);
        l11.setBounds(70,300,150,150);
        add(l11);

        ImageIcon i111=new ImageIcon(ClassLoader.getSystemResource("icon/driver1.png"));
        Image i222=i111.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i333=new ImageIcon(i222);
        JLabel l111=new JLabel(i333);
        l111.setBounds(70,500,150,150);
        add(l111);

        ImageIcon i21=new ImageIcon(ClassLoader.getSystemResource("icon/Login.gif"));
        Image i212=i21.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i213=new ImageIcon(i212);
        JLabel l1121=new JLabel(i213);
        l1121.setBounds(950,100,800,800);
        add(l1121);

        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1930,1200);
        setVisible(true);
    };
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_emp){
            new AddEmployee();
        }else if(e.getSource()==add_room){
            new AddRoom();
        }else if(e.getSource()==add_drivers){
            new AddDriver();
        }else if(e.getSource()==Logout){
            System.out.println("Exiting with code 201");
            System.exit(201);
        }else if(e.getSource()==Back){
            new Dashboard();
            this.setVisible(false);
        }
    }   
    public static void main(String[] args) {
        new Admin();
    }
}
