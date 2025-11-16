package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame {
    public CustomerInfo() {

        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5, 5, 1290, 590);
        panel.setLayout(null);
        add(panel);

        JLabel  title = new JLabel("Customer Information");
        title.setBounds(400, 11, 460, 90);
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        panel.add(title);

        JLabel Id=new JLabel("ID Type");
        Id.setFont(new Font("Serif", Font.BOLD, 20));
        Id.setForeground(Color.WHITE);
        Id.setBounds(80, 100, 100, 30);
        panel.add(Id);

        JLabel number=new JLabel("Number");
        number.setFont(new Font("Serif", Font.BOLD, 20));
        number.setForeground(Color.WHITE);
        number.setBounds(230, 100, 100, 30);
        panel.add(number);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        name.setBounds(380, 100, 100, 30);
        panel.add(name); 

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Serif", Font.BOLD, 20));
        gender.setForeground(Color.WHITE);
        gender.setBounds(530, 100, 100, 30);
        panel.add(gender);

        JLabel Country=new JLabel("Country");
        Country.setFont(new Font("Serif", Font.BOLD, 20));
        Country.setForeground(Color.WHITE);
        Country.setBounds(680, 100, 100, 30);
        panel.add(Country);

        JLabel roomNo=new JLabel("Room No");
        roomNo.setFont(new Font("Serif", Font.BOLD, 20));
        roomNo.setForeground(Color.WHITE);
        roomNo.setBounds(830, 100, 100, 30);
        panel.add(roomNo);  

        JLabel date=new JLabel("Check-In Date");
        date.setFont(new Font("Serif", Font.BOLD, 20));
        date.setForeground(Color.WHITE);
        date.setBounds(960, 100, 150, 30);
        panel.add(date);

        JLabel deposit=new JLabel("Deposit");
        deposit.setFont(new Font("Serif", Font.BOLD, 20));
        deposit.setForeground(Color.WHITE);
        deposit.setBounds(1130, 100, 100, 30);
        panel.add(deposit);

        JTable table = new JTable();
        table.setRowHeight(28);
        table.setFont(new Font("Serif",Font.PLAIN,17));
        table.setBounds(50, 137, 1190, 300);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        table.setEnabled(false);
        // table.getTableHeader().setBackground(new Color(3,45,48));
        // table.getTableHeader().setForeground(new Color(3,45,48));
        panel.add(table);


        // JScrollPane scrollPane = new JScrollPane();
        // scrollPane.setViewportView(table);  
        // scrollPane.setBackground(new Color(3,45,48)); 
        // scrollPane.setBounds(65, 200, 820, 250);
        // panel.add(scrollPane);

        try {
            Connect conn = new Connect();
            String query = "SELECT * FROM customer";
            ResultSet rs = conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back= new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,25));
        back.setBounds(500,480,180,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setSize(1300, 600);
        setLocation(475, 85);
        setVisible(true);
        
    }   
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
