package Hotel.Management.System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AddRoom extends JFrame implements ActionListener{
    JTextField t2,t4;
    JComboBox t3,t5,t6;
    JButton b1,b2;
    public AddRoom() {
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel l1=new JLabel("Add Room Details");
        l1.setBounds(500, 28, 450, 40);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(l1);

        JLabel l2=new JLabel("ROOM NUMBER");
        l2.setBounds(55, 30, 152, 35);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.BOLD, 18));
        panel.add(l2);
        t2=new JTextField();
        t2.setBounds(220, 30, 156, 35);
        t2.setFont(new Font("Tahoma", Font.BOLD, 15));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        JLabel l3=new JLabel("AVAILABILITY");
        l3.setBounds(55, 110, 152, 35);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        panel.add(l3);

        t3=new JComboBox(new String[] {"Available","Occupied"});
        t3.setBounds(220, 110, 156, 35);
        t3.setFont(new Font("Tahoma", Font.BOLD, 15));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        JLabel l4=new JLabel("PRICE");
        l4.setBounds(55, 200, 152, 35);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("serif", Font.BOLD, 20));
        panel.add(l4);

        t4=new JTextField();
        t4.setBounds(220, 200, 156, 35);
        t4.setFont(new Font("Tahoma", Font.BOLD, 15));
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);

        JLabel l5=new JLabel("CLEANING STATUS");
        l5.setBounds(55, 290, 152, 35);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("serif", Font.BOLD, 16));
        panel.add(l5);

        t5=new JComboBox(new String[] {"Cleaned","Dirty"});
        t5.setBounds(220, 290, 156, 35);
        t5.setFont(new Font("Tahoma", Font.BOLD, 15));
        t5.setForeground(Color.WHITE);
        t5.setBackground(new Color(16,108,115));
        panel.add(t5);

        JLabel l6=new JLabel("BED TYPE");
        l6.setBounds(55, 380, 152, 35);
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("serif", Font.BOLD, 20));
        panel.add(l6);

        t6=new JComboBox(new String[] {"Single Bed","Double Bed","Suite"});
        t6.setBounds(220, 380, 156, 35);
        t6.setFont(new Font("Tahoma", Font.BOLD, 15));
        t6.setForeground(Color.WHITE);
        t6.setBackground(new Color(16,108,115));
        panel.add(t6);

        b1=new JButton("Add");
        b1.setBounds(100, 480, 150, 50);
        b1.setFont(new Font("Tahoma", Font.BOLD, 20));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);
        b2=new JButton("Back");
        b2.setBounds(270, 480, 150, 50);
        b2.setFont(new Font("Tahoma", Font.BOLD, 20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image i2=i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(480, 120, 300, 300);
        panel.add(label);

        setUndecorated(true);
        setLayout(null);
        setLocation(35,135);
        setSize(900, 600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Connect c=new Connect();
                String room=t2.getText();
                String available=(String)t3.getSelectedItem();
                String price=t4.getText();
                String cleaningStatus=(String)t5.getSelectedItem();
                String bedType=(String)t6.getSelectedItem();

                String query="insert into room values('"+room+"','"+available+"','"+price+"','"+cleaningStatus+"','"+bedType+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                this.setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else  {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddRoom();
    }
}
