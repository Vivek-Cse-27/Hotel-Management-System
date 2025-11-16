package Hotel.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AddDriver extends JFrame implements ActionListener{
    JTextField nametext,agetext,phonetext,cartext,carntext,loctext;
    JComboBox genderBox,availablebox;
    JButton add,back;

    AddDriver(){
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label=new JLabel("Add Driver Details");
        label.setBounds(500, 28, 450, 40);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD, 30));
        panel.add(label);

        JLabel name=new JLabel("NAME");
        name.setBounds(60, 30, 150, 27);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("serif",Font.BOLD, 20));
        panel.add(name);
        nametext=new JTextField();
        nametext.setBounds(200, 30, 150, 30);
        nametext.setBackground(new Color(16,108,115));
        nametext.setForeground(Color.WHITE);
        nametext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(nametext);

        JLabel age=new JLabel("AGE");
        age.setBounds(60, 80, 150, 27);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("serif",Font.BOLD, 20));
        panel.add(age);
        agetext=new JTextField();
        agetext.setBounds(200, 80, 150, 30);
        agetext.setBackground(new Color(16,108,115));
        agetext.setForeground(Color.WHITE);
        agetext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(agetext);

        JLabel phone=new JLabel("PHONE");
        phone.setBounds(60, 130, 150, 27);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("serif",Font.BOLD, 20));
        panel.add(phone);
        phonetext=new JTextField();
        phonetext.setBounds(200, 130, 150, 30);
        phonetext.setBackground(new Color(16,108,115));
        phonetext.setForeground(Color.WHITE);
        phonetext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(phonetext);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(60, 180, 150, 27);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("serif",Font.BOLD, 20));
        panel.add(gender);
        genderBox = new JComboBox(new String[]{"Male", "Female", "Other"});
        genderBox.setBounds(200, 180, 150, 30);
        genderBox.setBackground(new Color(16,108,115));
        genderBox.setForeground(Color.WHITE);
        genderBox.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(genderBox);

        JLabel carc=new JLabel("CAR COMPANY");
        carc.setBounds(60, 230, 150, 27);
        carc.setForeground(Color.WHITE);
        carc.setFont(new Font("serif",Font.BOLD, 18));
        panel.add(carc);
        cartext=new JTextField();
        cartext.setBounds(200, 230, 150, 30);
        cartext.setBackground(new Color(16,108,115));
        cartext.setForeground(Color.WHITE);
        cartext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(cartext);

        JLabel carn=new JLabel("CAR NAME");
        carn.setBounds(60, 280, 150, 27);
        carn.setForeground(Color.WHITE);
        carn.setFont(new Font("serif",Font.BOLD, 20));
        panel.add(carn);
        carntext=new JTextField();
        carntext.setBounds(200, 280, 150, 30);
        carntext.setBackground(new Color(16,108,115));
        carntext.setForeground(Color.WHITE);
        carntext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(carntext);

        JLabel avl=new JLabel("AVAILABLE");
        avl.setBounds(60, 330, 150, 27);
        avl.setForeground(Color.WHITE);
        avl.setFont(new Font("serif",Font.BOLD, 20));
        panel.add(avl);
        availablebox = new JComboBox(new String[]{"Yes", "No"});
        availablebox.setBounds(200, 330, 150, 30);
        availablebox.setBackground(new Color(16,108,115));
        availablebox.setForeground(Color.WHITE);
        availablebox.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(availablebox);

        JLabel loc=new JLabel("LOCATION");
        loc.setBounds(60, 380, 150, 27);
        loc.setForeground(Color.WHITE);
        loc.setFont(new Font("serif",Font.BOLD, 20));
        panel.add(loc);
        loctext=new JTextField();
        loctext.setBounds(200, 380, 150, 30);
        loctext.setBackground(new Color(16,108,115));
        loctext.setForeground(Color.WHITE);
        loctext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(loctext);

        add=new JButton("Add");
        add.setBounds(100,480,150,50);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.BOLD,20));
        add.addActionListener(this);
        panel.add(add);
        back=new JButton("Back");
        back.setBounds(270,480,150,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,20));
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image i2=i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(480, 120, 300, 300);
        panel.add(image);

        setUndecorated(true);
        setLocation(35,135);
        setSize(900,600);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == add) {
            String gender = (String) genderBox.getSelectedItem();
            String carCompany = cartext.getText();
            String carName = carntext.getText();
            String available = (String) availablebox.getSelectedItem();
            String location = loctext.getText();
            String name = nametext.getText();
            String age = agetext.getText();
            String phone = phonetext.getText();
            try {
                Connect conn = new Connect();
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+phone+"','"+carCompany+"','"+carName+"','"+available+"','"+location+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
