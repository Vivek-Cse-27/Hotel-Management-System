package Hotel.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class CheckIn extends JFrame implements ActionListener{

    JComboBox comboBox;
    JRadioButton r1,r2;
    JTextField textFieldNumber,textFieldName,textFieldCountry,textFieldDeposit ;
    Choice c1;
    JLabel date;
    JButton add,back;
    public CheckIn() {
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
       JPanel panel=new JPanel();
       panel.setBounds(5,5,1290,590);
       panel.setBackground(new Color(3,45,48));
       panel.setLayout(null);    
       add(panel);

       ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/check.png"));
       Image scaledImg = img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
       ImageIcon scaledIcon = new ImageIcon(scaledImg);
       JLabel imageLabel = new JLabel(scaledIcon);
       imageLabel.setBounds(900, 150, 300, 300);
       panel.add(imageLabel);

       JLabel title = new JLabel("New Customer Form");
       title.setBounds(118,11,460,90);
       title.setFont(new Font("Tahoma", Font.BOLD, 40));
       title.setForeground(Color.WHITE);
       panel.add(title);
       
       JLabel labelID = new JLabel("ID :");
       labelID.setBounds(50,120,150,30);
       labelID.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelID.setForeground(Color.WHITE);
       panel.add(labelID);
       comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter ID", "Driving License"});
       comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
       comboBox.setBounds(300, 120, 350, 30);
       comboBox.setForeground(Color.WHITE);
       comboBox.setBackground(new Color(16,108,115));
       panel.add(comboBox);

       JLabel labelNumber = new JLabel("Id Number :");
       labelNumber.setBounds(50,160,150,30);
       labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelNumber.setForeground(Color.WHITE);
       panel.add(labelNumber);
       textFieldNumber = new JTextField();
       textFieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
       textFieldNumber.setBounds(300, 160, 350, 30);
       textFieldNumber.setForeground(Color.WHITE);
       textFieldNumber.setBackground(new Color(16,108,115));
       panel.add(textFieldNumber);

       JLabel labelName = new JLabel("Name :");
       labelName.setBounds(50,200,150,30);
       labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelName.setForeground(Color.WHITE);
       panel.add(labelName);
       textFieldName = new JTextField();
       textFieldName.setBounds(300, 200, 350, 30);
       textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 18));
       textFieldName.setForeground(Color.WHITE);
       textFieldName.setBackground(new Color(16,108,115));
       panel.add(textFieldName);

       JLabel labelGender = new JLabel("Gender :");
       labelGender.setBounds(50,240,150,30);
       labelGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelGender.setForeground(Color.WHITE);
       panel.add(labelGender);
       r1= new JRadioButton("Male");
       r1.setFont(new Font("Tahoma", Font.BOLD, 18));
       r1.setBounds(300, 240, 100, 30);
       r1.setBackground(new Color(3,45,48));
       r1.setForeground(Color.white);
       panel.add(r1);
       r2= new JRadioButton("Female");
       r2.setBounds(400, 240, 350, 30);
       r2.setFont(new Font("Tahoma", Font.BOLD, 18));
       r2.setBackground(new Color(3,45,48));
       r2.setForeground(Color.white);
       panel.add(r2);

       JLabel labelCountry = new JLabel("Country :");
       labelCountry.setBounds(50,280,150,30);
       labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelCountry.setForeground(Color.WHITE);
       panel.add(labelCountry);
       textFieldCountry = new JTextField();
       textFieldCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
       textFieldCountry.setBounds(300, 280, 350, 30);
       textFieldCountry.setForeground(Color.WHITE);
       textFieldCountry.setBackground(new Color(16,108,115));
       panel.add(textFieldCountry);

       JLabel labelRoom= new JLabel("Allocated Room Number :");
       labelRoom.setBounds(50,320,200,30);
       labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelRoom.setForeground(Color.WHITE);
       panel.add(labelRoom);
       c1=new Choice();
       try {
           Connect c=new Connect();
           String query="select * from room where availability='Available'";
           ResultSet rs=c.statement.executeQuery(query);
           while(rs.next()) {
               c1.add(rs.getString("roomno"));
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       c1.setBounds(300,320,350,30);
       c1.setFont(new Font("Tahoma", Font.BOLD, 18));
       c1.setForeground(Color.WHITE);
       c1.setBackground(new Color(16,108,115));
       panel.add(c1);

       JLabel labelCIS=new JLabel("Checked-In :");
       labelCIS.setBounds(50,360,150,30);
       labelCIS.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelCIS.setForeground(Color.WHITE);
       panel.add(labelCIS);

       Date date1=new Date();
       date=new JLabel(""+date1);
       date.setBounds(300,360,350,30);
       date.setForeground(Color.WHITE);
       date.setFont(new Font("Tahoma", Font.BOLD, 18));
       panel.add(date);

       JLabel labelDeposit=new JLabel("Deposit :");
       labelDeposit.setBounds(50,400,150,30);
       labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
       labelDeposit.setForeground(Color.WHITE);
       panel.add(labelDeposit);
       textFieldDeposit = new JTextField();
       textFieldDeposit.setBounds(300, 400, 350, 30);
       textFieldDeposit.setFont(new Font("Tahoma", Font.PLAIN, 18));
       textFieldDeposit.setForeground(Color.WHITE);
       textFieldDeposit.setBackground(new Color(16,108,115));
       panel.add(textFieldDeposit);

       add=new JButton("Add");
       add.setFont(new Font("Tahoma",Font.BOLD,25));
       add.setBounds(50,500,200,50);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       panel.add(add);

       back=new JButton("Back");
       back.setFont(new Font("Tahoma",Font.BOLD,25));
       back.setBounds(300,500,200,50);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setSize(1300,600);
        setLocation(475,85);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add) {
            Connect c=new Connect();
            String id=(String)comboBox.getSelectedItem();
            String number=textFieldNumber.getText();
            String name=textFieldName.getText();
            String rbtn=null;
            if(r1.isSelected()) {
                rbtn="Male";
            } else if(r2.isSelected()) {
                rbtn="Female";
            }
            String country=textFieldCountry.getText();
            String room=c1.getSelectedItem();
            String checkin=date.getText();
            String deposit=textFieldDeposit.getText();

            try{
            String query1="insert into customer values('"+id+"','"+number+"','"+name+"','"+rbtn+"','"+country+"','"+room+"','"+checkin+"','"+deposit+"')";
            String query2="update room set availability='Occupied' where roomno='"+room+"'";
            c.statement.executeUpdate(query1);
            c.statement.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
            setVisible(false);
            }catch(Exception ae) {
                ae.printStackTrace();
            }

        } else  {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new CheckIn();
    }
}
