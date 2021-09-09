package Employee;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Add_Employee implements ActionListener{

    JFrame f;
    JLabel id,id1,id3,id5,id7,id8,id12,id15,id16,id17,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t7,t11,t12,t13;
    JButton b,b1,b2,b3;

    Add_Employee(int i){}
    
    Add_Employee(){
        f = new JFrame("Add Employee");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource
        ("icons/add_employee.jpg")); //الصورة في الصفحة 
        id15.setIcon(img);
                f.getContentPane().setBackground(Color.white);

        

        id8 = new JLabel("New Employee Details");
        id8.setBounds(100,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("ename : ");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id3= new JLabel("pname : ");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id5= new JLabel("esalary : ");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        id7= new JLabel("pciry : ");
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

        id12= new JLabel("employee Id  : "); // حجم مربع النص 
        id12.setBounds(50,350,200,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id12);

        t11=new JTextField();   
        t11.setBounds(200,350,150,30);
        id15.add(t11);

        
        lab=new JLabel(); 
        lab.setBounds(200,450,250,200);
	id15.add(lab);

        lab1=new JLabel("");
        lab1.setBounds(600,450,250,50);
        id15.add(lab1);

        b = new JButton("Submit");
        b.setBackground(Color.white); // لون الزر 
        b.setForeground(Color.black);
        b.setBounds(100,400,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.white); // لون الزر 
        b1.setForeground(Color.black);// لون الخط 
        b1.setBounds(300,400,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(600,600); // حجم الصفحة 
        f.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String c = t3.getText();
        String e = t5.getText();
        String g = t7.getText();
        String k = t11.getText();
        if(ae.getSource() == b){
            try{
                conn cc = new conn();
                String q = "insert into employee values('"+a+"','"+c+"','"+e+"','"+g+"','"+k+"')"; // اسم الجدول 
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new details();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new details();
        }
    }
    public static void main(String[ ] arg){
        new Add_Employee();
    }
}