package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateCI extends JFrame implements ActionListener {

    public UpdateCI() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1290, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/uci.png"));
        Image img1 = img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon cimg = new ImageIcon(img1);
        JLabel image = new JLabel(cimg);
        image.setBounds(900, 100, 300, 300);
        panel.add(image);

        JLabel title = new JLabel("Update Check-In Details");
        title.setFont(new Font("Tahoma", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        title.setBounds(190, 5, 500, 90);
        panel.add(title);

        JLabel id = new JLabel("ID :");
        id.setBounds(50, 110, 40, 30);
        id.setFont(new Font("Tahoma", Font.PLAIN, 20));
        id.setForeground(Color.WHITE);
        panel.add(id);

        Choice c = new Choice();
        c.setBackground(new Color(3, 45, 48));
        c.setForeground(Color.WHITE);
        c.setFont(new Font("Tahoma", Font.BOLD, 22));
        c.setBounds(350, 115, 350, 30);
        panel.add(c);

        try {
            Connect conn = new Connect();
            ResultSet rs = conn.statement.executeQuery("select * from customer");
            while (rs.next()) {
                c.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel number = new JLabel("Room Number :");
        number.setBounds(50, 160, 150, 30);
        number.setFont(new Font("Tahoma", Font.PLAIN, 20));
        number.setForeground(Color.WHITE);
        panel.add(number);

        JTextField textFieldNumber = new JTextField();
        textFieldNumber.setBounds(350, 160, 350, 30);
        textFieldNumber.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldNumber.setForeground(Color.WHITE);
        textFieldNumber.setBackground(new Color(16, 108, 115));
        panel.add(textFieldNumber);

        JLabel name = new JLabel("Name :");
        name.setBounds(50, 210, 150, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(350, 210, 350, 30);
        textFieldName.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldName.setForeground(Color.WHITE);
        textFieldName.setBackground(new Color(16, 108, 115));
        panel.add(textFieldName);

        JLabel ci = new JLabel("Checked-In :");
        ci.setBounds(50, 260, 150, 30);
        ci.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ci.setForeground(Color.WHITE);
        panel.add(ci);

        JTextField textFieldCI = new JTextField();
        textFieldCI.setBounds(350, 260, 350, 30);
        textFieldCI.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldCI.setForeground(Color.WHITE);
        textFieldCI.setBackground(new Color(16, 108, 115));
        panel.add(textFieldCI);

        JLabel deposit = new JLabel("Amount Paid (₹):");
        deposit.setBounds(50, 310, 175, 30);
        deposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deposit.setForeground(Color.WHITE);
        panel.add(deposit);

        JTextField textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(350, 310, 350, 30);
        textFieldDeposit.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldDeposit.setForeground(Color.WHITE);
        textFieldDeposit.setBackground(new Color(16, 108, 115));
        panel.add(textFieldDeposit);

        JLabel pending = new JLabel("Pending Amount (₹):");
        pending.setBounds(50, 360, 200, 30);
        pending.setFont(new Font("Tahoma", Font.PLAIN, 18));
        pending.setForeground(Color.WHITE);
        panel.add(pending);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(350, 360, 350, 30);
        textFieldPending.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldPending.setForeground(Color.WHITE);
        textFieldPending.setBackground(new Color(16, 108, 115));
        textFieldPending.setEditable(false);
        panel.add(textFieldPending);

        JButton Update = new JButton("Update");
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.setFont(new Font("Tahoma", Font.BOLD, 28));
        Update.setBounds(80, 445, 200, 50);

        Update.addActionListener(ae -> {
            String idnumber = c.getSelectedItem();
            String roomNumber = textFieldNumber.getText();
            String nameStr = textFieldName.getText();
            String checkIn = textFieldCI.getText();
            String depositPaid = textFieldDeposit.getText();

            try {
                Connect conn = new Connect();

                String query1 = "update customer set room='" + roomNumber + "', name='" + nameStr +
                                "', checkintime='" + checkIn + "', deposit='" + depositPaid +
                                "' where number='" + idnumber + "'";

                String query2 = "update room set availability='Occupied' where roomno='" + roomNumber + "'";

                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Check-In Details Updated Successfully");
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        panel.add(Update);

        JButton back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.BOLD, 28));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(320, 445, 200, 50);
        back.addActionListener(e -> setVisible(false));
        panel.add(back);

        JButton check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Tahoma", Font.BOLD, 28));
        check.setBounds(560, 445, 200, 50);

        check.addActionListener(ae -> {
            String idnumber = c.getSelectedItem();

            try {
                Connect conn = new Connect();

                String q1 = "select * from customer where number='" + idnumber + "'";
                ResultSet rs = conn.statement.executeQuery(q1);

                if (rs.next()) {

                    textFieldNumber.setText(rs.getString("room"));
                    textFieldName.setText(rs.getString("name"));
                    textFieldCI.setText(rs.getString("checkintime"));
                    textFieldDeposit.setText(rs.getString("deposit"));

                    String roomNumber = rs.getString("room");
                    int depositPaid = Integer.parseInt(rs.getString("deposit"));
                    Statement st2 = conn.connection.createStatement();
                    String q2 = "select * from room where roomno='" + roomNumber + "'";
                    ResultSet rs2 = st2.executeQuery(q2);

                    if (rs2.next()) {
                        int price = Integer.parseInt(rs2.getString("price"));
                        int pendingAmount = price - depositPaid;
                        textFieldPending.setText("" + pendingAmount);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        panel.add(check);

        setUndecorated(true);
        setLayout(null);
        setSize(1300, 600);
        setLocation(475, 85);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    public static void main(String[] args) {
        new UpdateCI();
    }
}
