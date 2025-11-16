package Hotel.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CheckOut extends JFrame implements ActionListener{
    public CheckOut(){
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1290, 590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(350, 30, 490, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 40));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel id=new JLabel("Customer ID:");
        id.setBounds(50, 100, 200, 30);
        id.setFont(new Font("Tahoma", Font.PLAIN, 20));
        id.setForeground(Color.white);
        panel.add(id);

        Choice c1=new Choice();
        c1.setBounds(250, 95, 320, 30);
        c1.setFont(new Font("Tahoma", Font.BOLD, 24));
        c1.setBackground(new Color(3,45,48));
        c1.setForeground(Color.white);
        panel.add(c1);

        try {
            Connect conn=new Connect();
            ResultSet rs=conn.statement.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel RoomNumber=new JLabel("Room Number:");
        RoomNumber.setBounds(50, 160, 200, 30);
        RoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        RoomNumber.setForeground(Color.white);
        panel.add(RoomNumber);

        JLabel Number=new JLabel();
        Number.setBounds(250, 160, 200, 30);
        Number.setFont(new Font("Tahoma", Font.BOLD, 24));
        Number.setForeground(Color.white);
        panel.add(Number);
        

        JLabel CheckInTime=new JLabel("Check-In Time:");
        CheckInTime.setBounds(50, 220, 200, 30);
        CheckInTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        CheckInTime.setForeground(Color.white);
        panel.add(CheckInTime);

        JLabel Time=new JLabel();
        Time.setBounds(250, 220, 400, 30);
        Time.setFont(new Font("Tahoma", Font.BOLD, 24));
        Time.setForeground(Color.white);
        panel.add(Time);

        JLabel CheckOutTime=new JLabel("Check-Out Time:");
        CheckOutTime.setBounds(50, 280, 200, 30);
        CheckOutTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        CheckOutTime.setForeground(Color.white);
        panel.add(CheckOutTime);

        Date date=new Date();
        

        JLabel Time2=new JLabel(""+date);
        Time2.setBounds(250, 280, 400, 30);
        Time2.setFont(new Font("Tahoma", Font.BOLD, 24));
        Time2.setForeground(Color.white);
        panel.add(Time2);

        JButton CO=new JButton("Check-Out");
        CO.setBackground(Color.BLACK);
        CO.setForeground(Color.WHITE);
        CO.setFont(new Font("Tahoma", Font.BOLD, 28));
        CO.setBounds(80,445,200,50);
        CO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connect conn=new Connect();
                    String num=c1.getSelectedItem();
                    String query1="delete from customer where number='"+num+"'";
                    String query2="update room set availability='Available' where roomno='"+Number.getText()+"'";
                    conn.statement.executeUpdate(query1);
                    conn.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Check-Out Successfull");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(CO);

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

        JButton check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Tahoma", Font.BOLD, 28));
        check.setBounds(560, 445, 200, 50);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
            Connect conn=new Connect();
            String num=c1.getSelectedItem();
            
            ResultSet rs=conn.statement.executeQuery("select * from customer where number='"+num+"'");
            while(rs.next()){
                Number.setText(rs.getString("room"));
                Time.setText(rs.getString("checkintime"));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});
        panel.add(check);


        setUndecorated(true);
        setLayout(null);
        setSize( 1300, 600);
        setLocation(475,85);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
    
    public static void main(String[] args) {
        new CheckOut();
    }
    
}
