package Hotel.Management.System;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
public class RoomSearch extends JFrame implements ActionListener{
    JCheckBox checkBox;
    Choice choice;
    JButton search,back;
    JTable table;
    public RoomSearch() {
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1290, 590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel searchRoom = new JLabel("Search for Room");
        searchRoom.setBounds(320, 11, 460, 90);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(searchRoom);

        JLabel bedType = new JLabel("Room Bed Type:");
        bedType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bedType.setForeground(Color.WHITE);
        bedType.setBounds(100, 115, 120, 30);
        panel.add(bedType);

        JLabel roomNo=new JLabel("Room Number");
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 20));
        roomNo.setForeground(Color.WHITE);
        roomNo.setBounds(68, 164, 150, 30);
        panel.add(roomNo);

        JLabel availability=new JLabel("Availability");;
        availability.setFont(new Font("Tahoma", Font.BOLD, 20));
        availability.setForeground(Color.WHITE);
        availability.setBounds(254, 164, 150, 30);
        panel.add(availability);

        JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma", Font.BOLD, 20));
        price.setForeground(Color.WHITE);
        price.setBounds(408, 164, 150, 30);
        panel.add(price);

        JLabel status=new JLabel("Clean Status");
        status.setFont(new Font("Tahoma", Font.BOLD, 20));
        status.setForeground(Color.WHITE);
        status.setBounds(560, 164, 180, 30);
        panel.add(status);

        JLabel bed=new JLabel("Bed Type");;
        bed.setFont(new Font("Tahoma", Font.BOLD, 20));
        bed.setForeground(Color.WHITE);
        bed.setBounds(762, 164, 150, 30);
        panel.add(bed);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        checkBox.setBounds(550, 115, 200, 30);
        checkBox.setForeground(Color.white);
        checkBox.setBackground(new Color(3,45,48));
        panel.add(checkBox);

        choice= new Choice();
        choice.add("All");
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.add("Suite");
        choice.setBounds(230, 118, 200, 30);
        panel.add(choice);

        table = new JTable();
        table.setBounds(65, 200, 820, 250);
        table.setBackground(new Color(3,45,48));
        table.setRowHeight(28);
        table.setFont(new Font("Serif",Font.PLAIN,24));
        table.setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(3,45,48));
        table.getTableHeader().setForeground(new Color(3,45,48));
        panel.add(table);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);  
        scrollPane.setBackground(new Color(3,45,48)); 
        scrollPane.setBounds(65, 200, 820, 250);
        panel.add(scrollPane);

        try {
            Connect conn = new Connect();
            String query = "select * from room";
            ResultSet rs = conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        search= new JButton("Search");
        search.setFont(new Font("Tahoma",Font.BOLD,25));
        search.setBounds(80, 454, 200, 50);
        search.setBackground(Color.BLACK);
        search.addActionListener(this);
        search.setForeground(Color.WHITE);
        panel.add(search);

        back= new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,25));
        back.setBounds(325, 454, 200, 50);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setSize( 1300, 600);
        setLocation(475,85);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search) {
            if(choice.getSelectedItem().equals("All")) {
                String query = "select * from room";
                String query1 = "select * from room where availability='Available'";
                try {
                    Connect conn = new Connect();
                    ResultSet rs;
                    if(checkBox.isSelected()) {
                        rs = conn.statement.executeQuery(query1);
                    } else {
                        rs = conn.statement.executeQuery(query);
                    }
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else{
            String query1 = "select * from room where bed_type='"+choice.getSelectedItem()+"'";
            String query2 = "select * from room where availability='Available' and bed_type='"+choice.getSelectedItem()+"'";
            try {
                Connect conn = new Connect();
                ResultSet rs;
                if(checkBox.isSelected()) {
                    rs = conn.statement.executeQuery(query2);
                } else {
                    rs = conn.statement.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new RoomSearch();
    }
}