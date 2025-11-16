package Hotel.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateRS extends JFrame implements ActionListener {

    public UpdateRS() {

        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1290, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image img1 = img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon cimg = new ImageIcon(img1);
        JLabel image = new JLabel(cimg);
        image.setBounds(900, 100, 300, 300);
        panel.add(image);

        JLabel title = new JLabel("Update Room Status");
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
            String query = "select * from customer";
            ResultSet rs = conn.statement.executeQuery(query);
            while (rs.next()) {
                c.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel number = new JLabel("Room Number :");
        number.setBounds(50, 160, 180, 30);
        number.setFont(new Font("Tahoma", Font.PLAIN, 20));
        number.setForeground(Color.WHITE);
        panel.add(number);

        JTextField textFieldNumber = new JTextField();
        textFieldNumber.setBounds(350, 160, 350, 30);
        textFieldNumber.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldNumber.setForeground(Color.WHITE);
        textFieldNumber.setEditable(false);
        textFieldNumber.setBackground(new Color(16, 108, 115));
        panel.add(textFieldNumber);

        JLabel avl = new JLabel("Availability :");
        avl.setBounds(50, 210, 180, 30);
        avl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        avl.setForeground(Color.WHITE);
        panel.add(avl);

        JTextField textFieldAvl = new JTextField();
        textFieldAvl.setBounds(350, 210, 350, 30);
        textFieldAvl.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldAvl.setForeground(Color.WHITE);
        textFieldAvl.setBackground(new Color(16, 108, 115));
        panel.add(textFieldAvl);

        JLabel cs = new JLabel("Clean Status :");
        cs.setBounds(50, 260, 180, 30);
        cs.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cs.setForeground(Color.WHITE);
        panel.add(cs);

        JTextField textFieldCS = new JTextField();
        textFieldCS.setBounds(350, 260, 350, 30);
        textFieldCS.setFont(new Font("Tahoma", Font.BOLD, 22));
        textFieldCS.setForeground(Color.WHITE);
        textFieldCS.setBackground(new Color(16, 108, 115));
        panel.add(textFieldCS);

        JButton Update = new JButton("Update");
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.setFont(new Font("Tahoma", Font.BOLD, 28));
        Update.setBounds(80, 445, 200, 50);
        Update.addActionListener(e -> {
            String idnumber = c.getSelectedItem();
            String roomNumber = textFieldNumber.getText();
            String availability = textFieldAvl.getText();
            String cleanStatus = textFieldCS.getText();

            try {
                Connect conn = new Connect();
                String query1 = "update room set availability='" + availability
                        + "', clean_status='" + cleanStatus
                        + "' where roomno='" + roomNumber + "'";

                conn.statement.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Room Status Updated Successfully");
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
        back.addActionListener(e -> setVisible(false));
        back.setBounds(320, 445, 200, 50);
        panel.add(back);

        JButton check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Tahoma", Font.BOLD, 28));
        check.setBounds(560, 445, 200, 50);
        check.addActionListener(e -> {
            String idnumber = c.getSelectedItem();

            try {
                Connect conn = new Connect();
                String query = "select * from customer where number='" + idnumber + "'";

                ResultSet rs = conn.statement.executeQuery(query);

                while (rs.next()) {
                    String roomNum = rs.getString("room");
                    textFieldNumber.setText(roomNum);

                    Statement st2 = conn.connection.createStatement();
                    String query2 = "select * from room where roomno='" + roomNum + "'";
                    ResultSet rs2 = st2.executeQuery(query2);

                    while (rs2.next()) {
                        textFieldAvl.setText(rs2.getString("availability"));
                        textFieldCS.setText(rs2.getString("clean_status"));
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
        new UpdateRS();
    }
}
