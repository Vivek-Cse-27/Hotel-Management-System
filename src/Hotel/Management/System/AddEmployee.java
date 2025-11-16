package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{ 
    JTextField nametext,agetext,salarytext,phonetext,aadhartext,emailtext;
    JRadioButton rb1,rb2;
    JComboBox jobcombo;
    JButton add,back;

    public AddEmployee() {
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel =new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel AED=new JLabel("Add Employee Details");
        AED.setBounds(500, 28, 450, 40);
        AED.setFont(new Font("Tahoma", Font.BOLD, 30));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        JLabel name=new JLabel("NAME");
        name.setBounds(60, 30, 150, 27);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nametext=new JTextField();
        nametext.setBounds(200, 30, 150, 30);
        nametext.setBackground(new Color(16,108,115));
        nametext.setForeground(Color.WHITE);
        nametext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(nametext);

        JLabel age=new JLabel("AGE");
        age.setBounds(60, 80, 150, 27);
        age.setFont(new Font("serif", Font.BOLD, 20));
        age.setForeground(Color.WHITE);
        panel.add(age);
        agetext=new JTextField();
        agetext.setBounds(200, 80, 150, 30);
        agetext.setBackground(new Color(16,108,115));
        agetext.setForeground(Color.WHITE);
        agetext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(agetext);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(60, 130, 150, 27);
        gender.setFont(new Font("serif", Font.BOLD, 20));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        rb1=new JRadioButton("Male");
        rb1.setBounds(200, 130, 70, 30);
        rb1.setBackground(new Color(3,45,48));
        rb1.setForeground(Color.WHITE);
        rb1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(rb1);

        rb2=new JRadioButton("Female");
        rb2.setBounds(280, 130,150, 30);
        rb2.setBackground(new Color(3,45,48));
        rb2.setForeground(Color.WHITE);
        rb2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(rb2);

        JLabel job=new JLabel("JOB");
        job.setBounds(60, 180, 150, 27);
        job.setFont(new Font("serif", Font.BOLD, 20));
        job.setForeground(Color.WHITE);
        panel.add(job);
        jobcombo=new JComboBox(new String[] {"Front Desk","Housekeeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        jobcombo.setBounds(200, 180, 150, 30);
        jobcombo.setBackground(new Color(16,108,115));
        jobcombo.setForeground(Color.WHITE);
        jobcombo.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(jobcombo);

        JLabel salary=new JLabel("SALARY");
        salary.setBounds(60, 230, 150, 27);
        salary.setFont(new Font("serif", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        salarytext=new JTextField();
        salarytext.setBounds(200, 230, 150, 30);
        salarytext.setBackground(new Color(16,108,115));
        salarytext.setForeground(Color.WHITE);
        salarytext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(salarytext);

        JLabel phone=new JLabel("PHONE");
        phone.setBounds(60, 280, 150, 27);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        phonetext=new JTextField();
        phonetext.setBounds(200, 280, 150, 30);
        phonetext.setBackground(new Color(16,108,115));
        phonetext.setForeground(Color.WHITE);
        phonetext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(phonetext);

        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setBounds(60, 330, 150, 27);
        aadhar.setFont(new Font("serif", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);
        aadhartext=new JTextField();
        aadhartext.setBounds(200, 330, 150, 30);
        aadhartext.setBackground(new Color(16,108,115));
        aadhartext.setForeground(Color.WHITE);
        aadhartext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(aadhartext);

        JLabel email=new JLabel("EMAIL");
        email.setBounds(60, 380, 150, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        panel.add(email);
        emailtext=new JTextField();
        emailtext.setBounds(200, 380, 150, 30);
        emailtext.setBackground(new Color(16,108,115));
        emailtext.setForeground(Color.WHITE);
        emailtext.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(emailtext);

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

        ImageIcon ig=new ImageIcon(ClassLoader.getSystemResource("icon/employee.png"));
        Image i2=ig.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon ig2=new ImageIcon(i2);
        JLabel image=new JLabel(ig2);
        image.setBounds(480, 120, 300, 300);
        panel.add(image);

        setUndecorated(true);
        setLocation(35,135);
        setLayout(null);
        setSize(900,600);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add) {
            String name=nametext.getText();
            String age=agetext.getText();
            String salary=salarytext.getText();
            String phone=phonetext.getText();
            String aadhar=aadhartext.getText();
            String email=emailtext.getText();
            String job=(String)jobcombo.getSelectedItem();
            String gender=null;
            if(rb1.isSelected()) {
                gender="Male";
            }else if(rb2.isSelected()) {
                gender="Female";
            }
            if(name.isEmpty() || age.isEmpty() || salary.isEmpty() || phone.isEmpty() || aadhar.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please fill all fields");
    return;
    }
            try {
                Connect c=new Connect();
                String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
                c.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
            }catch(Exception ex) {
                ex.printStackTrace();
            }

    }
    else{
        setVisible(false);
    }
}
    public static void main(String[] args) {
        new AddEmployee();
    }
}
