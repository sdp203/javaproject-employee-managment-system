package Employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Update_Employee extends Add_Employee implements ActionListener {

    JFrame f;
    JLabel id, id1, id3, id5, id7, id8, id10, id11, id12, id15, lab, lab1;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JButton b, b1, b2, b3;
    String id_emp;

    Update_Employee(String idaa) {
        super(0);
        f = new JFrame("update Employee details");
        f.setVisible(true);
        f.setSize(900, 500);
        f.setLocation(450, 250);
        f.setBackground(Color.white);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.white);

        id_emp = idaa;
        id15 = new JLabel();
        id15.setBounds(0, 0, 900, 500);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        id15.setIcon(img);

        id8 = new JLabel("Update Employee Detail:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id1 = new JLabel("ename:");
        id1.setBounds(50, 100, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id1);

        t1 = new JTextField();
        t1.setBounds(200, 100, 150, 30);
        id15.add(t1);

        id3 = new JLabel("pname:");
        id3.setBounds(50, 150, 100, 30);
        id3.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id3);

        t3 = new JTextField();
        t3.setBounds(200, 150, 150, 30);
        id15.add(t3);

        id5 = new JLabel("esalary:");
        id5.setBounds(50, 200, 100, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id5);

        t5 = new JTextField();
        t5.setBounds(200, 200, 150, 30);
        id15.add(t5);

        id7 = new JLabel("pcity");
        id7.setBounds(50, 250, 100, 30);
        id7.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id7);

        t7 = new JTextField();
        t7.setBounds(200, 250, 150, 30);
        id15.add(t7);

        id10 = new JLabel("Employee Id:");
        id10.setBounds(50, 300, 150, 30);
        id10.setFont(new Font("serif", Font.BOLD, 20));
        id15.add(id10);
        f.setVisible(false);
        t9 = new JTextField();
        t9.setBounds(200, 300, 150, 30);
        id15.add(t9);

        b = new JButton("update");
        b.setBounds(250, 400, 100, 30);
        b.addActionListener(this);
        id15.add(b);

        b1 = new JButton("Cancel");
        b1.setBounds(450, 400, 100, 30);
        b1.addActionListener(this);
        id15.add(b1);

        showData(idaa);
    }

    int i = 0;

    void showData(String s) {
        try {
            conn con = new conn();
            String str = "select * from employee where employee_ID= '" + s + "'";
            ResultSet rs = con.s.executeQuery(str);

            if (rs.next()) {
                f.setVisible(true);
                i = 1;

                t1.setText(rs.getString(1));
                t3.setText(rs.getString(5));
                t5.setText(rs.getString(7));
                t7.setText(rs.getString(9));
                t9.setText(rs.getString(11));
            }
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Id not found");
            }
            new Search_Employee();
        } catch (Exception ex) {
        }
        f.setVisible(true);
        f.setSize(900, 500);
        f.setLocation(400, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b && i == 1) {
            try {
                conn con = new conn();
                String str = "update employee set ename='" + t1.getText() + "',pname='" + t3.getText() + "',esalary='" + t5.getText() + "',pcity='" + t7.getText() + "',employee_ID='" + t9.getText() + "' where employee_ID='" + id_emp + "'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "successfully updated");
                f.setVisible(false);
                new Search_Employee();
            } catch (Exception e) {
                System.out.println("The error is:" + e);
            }
        }
        if (ae.getSource() == b1) {
            f.setVisible(false);
            details d = new details();
        }
    }

    public static void main(String[] arg) {
        new Update_Employee("Update Employee");
    }
}
