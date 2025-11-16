package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

public class Employee extends JFrame implements ActionListener{
    Employee(){
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel=new JPanel();
        panel.setBounds(5,5,1290,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Employee Details");
        title.setBounds(400, 5, 300, 50);
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        panel.add(title);

        JTable table=new JTable();
        table.setBounds(15,100,1250,410);
        table.setBackground(new Color(3,45,48));
        table.setRowHeight(25);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Serif",Font.BOLD,14));
        table.setEnabled(false);
        panel.add(table);
        


        try {
            Connect c=new Connect();
            String query="select * from employee";
            ResultSet rs=c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        back.setBounds(320, 510, 200, 50);
        panel.add(back);

        JLabel name=new JLabel("Name");
        name.setBounds(41,65,70,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(name);

        JLabel age=new JLabel("Age");
        age.setBounds(200,65,70,19);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(age);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(350,65,70,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(gender);

        JLabel job=new JLabel("Job");
        job.setBounds(500,65,70,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(job);

        JLabel salary=new JLabel("Salary");
        salary.setBounds(650,65,70,19); 
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(salary);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(820,65,70,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(phone);

        JLabel email=new JLabel("Email");
        email.setBounds(980,65,70,19);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(email);

        JLabel aadhar=new JLabel("Aadhar"); 
        aadhar.setBounds(1135,65,70,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahoma",Font.BOLD,18));
        panel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setSize(1300,600);
        setLocation(475,85);
        setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e) {}
    public static void main(String[] args) {
        new Employee();
    }
    
}
