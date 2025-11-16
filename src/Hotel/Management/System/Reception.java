package Hotel.Management.System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Reception extends JFrame implements ActionListener{
    Reception(){
        super("HOTEL RECEPTION");
        ImageIcon logo = new ImageIcon(getClass().getResource("/icon/favicon.png"));
        setIconImage(logo.getImage());
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(295,5,1600,1090);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,285,1090);
        panel1.setBackground(new Color(3,45,48));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Loading.gif"));
        Image img=i1.getImage().getScaledInstance(1300,1000, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(img);
        JLabel image=new JLabel(i2);
        image.setBounds(170,40,1300,1000);
        panel.add(image);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/Login.gif"));
        Image imge=i11.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon i22=new ImageIcon(imge);
        JLabel imagee=new JLabel(i22);
        imagee.setBounds(3,770,300,300);
        panel1.add(imagee);

        JButton newCustomer=new JButton("New Customer Form");
        newCustomer.setBounds(15,30,250,38);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(newCustomer);
        newCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckIn();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Room=new JButton("Room");
        Room.setBounds(15,80,250,38);
        Room.setBackground(Color.BLACK);
        Room.setForeground(Color.WHITE);
        Room.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(Room);
        Room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Department=new JButton("Department");
        Department.setBounds(15,130,250,38);
        Department.setBackground(Color.BLACK);
        Department.setForeground(Color.WHITE);
        Department.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(Department);
        Department.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new Department();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton AEI=new JButton("All Employee Info");
        AEI.setBounds(15,185,250,38);
        AEI.setBackground(Color.BLACK);
        AEI.setForeground(Color.WHITE);
        AEI.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(AEI);
        AEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new Employee();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton CI=new JButton("Customer Info");
        CI.setBounds(15,240,250,38);
        CI.setBackground(Color.BLACK);
        CI.setForeground(Color.WHITE);
        CI.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(CI);
        CI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new CustomerInfo();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton MI=new JButton("Manager Info");
        MI.setBounds(15,295,250,38);
        MI.setBackground(Color.BLACK);
        MI.setForeground(Color.WHITE);
        MI.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(MI);
        MI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new Manager();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Co=new JButton("Check Out");
        Co.setBounds(15,350,250,38);
        Co.setBackground(Color.BLACK);
        Co.setForeground(Color.WHITE);
        Co.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(Co);
        Co.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckOut();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton UCD=new JButton("Update Check-In Details");
        UCD.setBounds(15,405,250,38);
        UCD.setBackground(Color.BLACK);
        UCD.setForeground(Color.WHITE);
        UCD.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(UCD);
        UCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCI();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton URS=new JButton("Update Room Status");
        URS.setBounds(15,455,250,38);
        URS.setBackground(Color.BLACK);
        URS.setForeground(Color.WHITE);
        URS.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(URS);
        URS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new UpdateRS();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton PUS=new JButton("Pick Up Service");
        PUS.setBounds(15,510,250,38);
        PUS.setBackground(Color.BLACK);
        PUS.setForeground(Color.WHITE);
        PUS.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(PUS);
        PUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new PickUP();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton SR=new JButton("Search Room");
        SR.setBounds(15,565,250,38);
        SR.setBackground(Color.BLACK);
        SR.setForeground(Color.WHITE);
        SR.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(SR);
        SR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new RoomSearch();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(15,620,250,38);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                new Dashboard();
                setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Log=new JButton("Log Out");
        Log.setBounds(15,675,250,38);
        Log.setBackground(Color.BLACK);
        Log.setForeground(Color.WHITE);
        Log.setFont(new Font("serif",Font.BOLD,18));
        panel1.add(Log);
        Log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                System.out.println("Exiting with code 201");
                System.exit(201);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1930,1200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
    public static void main(String[] args) {
        new Reception();
    }
}
