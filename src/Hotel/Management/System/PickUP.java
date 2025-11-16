package Hotel.Management.System;

import java.awt.Choice;
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

public class PickUP extends JFrame implements ActionListener{
    public PickUP() {
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1290, 590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Pick Up Service");
        title.setBounds(450, 11, 400, 90);
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        panel.add(title);

        JLabel toc=new JLabel("Type of Car:");
        toc.setFont(new Font("Tahoma", Font.BOLD, 20));
        toc.setForeground(Color.WHITE);
        toc.setBounds(75, 100, 125, 30);
        panel.add(toc);

        Choice c=new Choice();
        c.setBounds(228, 105, 200, 30);
        c.setFont(new Font("Tahoma", Font.BOLD, 18));
        c.setBackground(new Color(3,45,48));
        c.setForeground(Color.WHITE);
        c.add("All");
        panel.add(c);

        try {
            Connect conn= new Connect();
            ResultSet rs= conn.statement.executeQuery("select * from driver where avl='Yes'");
            while(rs.next()) {
                c.add(rs.getString("carn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JTable table = new JTable();
        table.setRowHeight(28);
        table.setFont(new Font("Tahoma",Font.PLAIN,18));
        table.setBounds(50, 180, 1180, 250);
        table.setRowHeight(35);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        table.getTableHeader().setBackground(new Color(3,45,48));
        table.getTableHeader().setForeground(new Color(3,45,48));
        panel.add(table);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);  
        scrollPane.setBackground(new Color(3,45,48)); 
        scrollPane.setBounds(45, 180, 1180, 250);
        panel.add(scrollPane);

        try {
            Connect conn= new Connect();
            ResultSet rs= conn.statement.executeQuery("select * from driver where avl='Yes'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel driverName=new JLabel("Driver Name");
        driverName.setFont(new Font("Tahoma", Font.BOLD, 20));
        driverName.setForeground(Color.WHITE);
        driverName.setBounds(50, 140, 200, 30);
        panel.add(driverName);

        JLabel driverAge=new JLabel("Age");
        driverAge.setFont(new Font("Tahoma", Font.BOLD, 20));
        driverAge.setForeground(Color.WHITE);
        driverAge.setBounds(220, 140, 100, 30);
        panel.add(driverAge);

        JLabel driverGender=new JLabel("Gender");
        driverGender.setFont(new Font("Tahoma", Font.BOLD, 20));
        driverGender.setForeground(Color.WHITE);
        driverGender.setBounds(350, 140, 150, 30);
        panel.add(driverGender);

        JLabel contact=new JLabel("Contact No");;
        contact.setFont(new Font("Tahoma", Font.BOLD, 20));
        contact.setForeground(Color.WHITE);
        contact.setBounds(498, 140, 200, 30);
        panel.add(contact);

        JLabel driverCar=new JLabel("Car Company");
        driverCar.setFont(new Font("Tahoma", Font.BOLD, 20));
        driverCar.setForeground(Color.WHITE);
        driverCar.setBounds(645, 140, 200, 30);
        panel.add(driverCar);

        JLabel carName=new JLabel("Car Name");
        carName.setFont(new Font("Tahoma", Font.BOLD, 20));
        carName.setForeground(Color.WHITE);
        carName.setBounds(800, 140, 200, 30);
        panel.add(carName);

        JLabel available=new JLabel("Available");
        available.setFont(new Font("Tahoma", Font.BOLD, 20));
        available.setForeground(Color.WHITE);
        available.setBounds(950, 140, 200, 30);
        panel.add(available);

        JLabel location=new JLabel("Location");
        location.setFont(new Font("Tahoma", Font.BOLD, 20));
        location.setForeground(Color.WHITE);
        location.setBounds(1090, 140, 200, 30);
        panel.add(location);

        JLabel note=new JLabel("Note: Only Available Drivers are shown in the above table");
        note.setFont(new Font("Tahoma", Font.ITALIC, 16));
        note.setForeground(Color.RED);       
        note.setBounds(50, 520, 450, 30);
        panel.add(note);

        JButton search=new JButton("Search");
        search.setFont(new Font("Tahoma", Font.BOLD, 28));
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(90, 445, 200, 50);
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String type=c.getSelectedItem();
                try {
                    Connect conn= new Connect();
                    String query;
                    if(type.equals("All")) {
                        query="select * from driver where avl='Yes'";
                    } else {
                        query="select * from driver where carn='"+type+"' AND avl='Yes'";
                    }
                    ResultSet rs= conn.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        panel.add(search);

        JButton back=new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 28));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(320, 445, 200, 50);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setSize( 1300, 600);
        setLocation(475,85);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
    public static void main(String[] args) {
        new PickUP();
    }
}
