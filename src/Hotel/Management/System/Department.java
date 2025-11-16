package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame {
    Department(){
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,1290,590);
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(15,80,850,400);
        table.setBackground(new Color(3,45,48));
        table.setRowHeight(25);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Serif",Font.BOLD,20));
        table.setEnabled(false);
        panel.add(table);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/Coin.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(950,200,200,200);
        panel.add(l1);

        try {
            Connect c=new Connect();
            String str="select * from department";
            ResultSet rs=c.statement.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,28));
        back.setBounds(200,500,180,50);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel dept=new JLabel("Department");
        dept.setBounds(125,55,105,20);
        dept.setForeground(Color.WHITE);
        dept.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(dept);

        JLabel budget=new JLabel("Budget");
        budget.setBounds(525,55,105,20);
        budget.setForeground(Color.WHITE);
        budget.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(budget);

        setUndecorated(true);
        setLayout(null);
        setLocation(475,85);
        setSize(1300,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
