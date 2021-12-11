package parking.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class GenerateBill extends JFrame implements ActionListener {
    JButton b;
    JTextField tf;
    JLabel label0;
    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label10;
    JLabel label11;
    JLabel label12;
    JLabel label13;

    GenerateBill(){
        //button
        b = new JButton();
        b.setText("Generate Bill");
        b.setBounds(280,97,109,25);
        b.addActionListener(this);
        b.setFocusable(false);
        this.add(b);

        //textfield
        tf = new JTextField(10);
        tf.setBounds(105,100,170,20);
        this.add(tf);

        //lablels
        label0 = new JLabel("Type your vehicle number -");
        label = new JLabel("** BILL **");
        label2 = new JLabel("VNumber    : ");
        label3 = new JLabel("Model         : " );
        label4 = new JLabel("Time           : " );
        label5 = new JLabel("Paid           : ");
        label10 = new JLabel("********** END **********");
        label11 = new JLabel("-- Parking Rates --");
        label12 = new JLabel("Two-wheelers : 10₹/hr");
        label13 = new JLabel("Four-wheelers : 30₹/hr");
        label0.setBounds(104,75,200,20);
        label.setBounds(210,150,100,20);
        label2.setBounds(170,170,100,20);
        label3.setBounds(170,190,100,20);
        label4.setBounds(170,210,100,20);
        label5.setBounds(172,230,100,20);
        label10.setBounds(170,260,200,20);
        label11.setBounds(175,20,200,20);
        label12.setBounds(166,35,200,20);
        label13.setBounds(166,50,200,20);
        label.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label10.setVisible(false);
        this.add(label0);
        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label10);
        this.add(label11);
        this.add(label12);
        this.add(label13);

        //frame
        this.setSize(500,400); //sets x & y dim
        this.setTitle("GenerateBill.exe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("F:\\Java\\ParkingSystem\\lib\\car2.jpg"); //creating an image object
        this.setIconImage(icon.getImage()); //setting the image to frame
        this.setVisible(true); //make frame visible

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b) {
            try{
                Connection con = Connector.createC();
                String q = "select * from parking where numberplate='"+ tf.getText() +"'";
                PreparedStatement ps = con.prepareStatement(q);
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    String vno = rs.getString(1);
                    String vtype = rs.getString(2);
                    String model = rs.getString(3);
                    int time = rs.getInt(5);

                    //lables
                    JLabel label6 = new JLabel(vno);
                    JLabel label7 = new JLabel(model);
                    JLabel label8 = new JLabel(time + " hr");
                    JLabel label9;
                    if (Objects.equals(vtype, "Two-wheeler")) {
                        label9 = new JLabel(time * 10 + " ₹");
                    }
                    else{
                        label9 = new JLabel(time * 30 + " ₹");
                    }
                    label6.setBounds(250, 170, 100, 20);
                    label7.setBounds(250, 190, 100, 20);
                    label8.setBounds(250, 210, 100, 20);
                    label9.setBounds(250, 230, 100, 20);
                    this.add(label6);
                    this.add(label7);
                    this.add(label8);
                    this.add(label9);
                    label.setVisible(true);
                    label2.setVisible(true);
                    label3.setVisible(true);
                    label4.setVisible(true);
                    label5.setVisible(true);
                    label10.setVisible(true);

                    String q2 = "delete from parking where numberplate = ?";
                    PreparedStatement ps2 = con.prepareStatement(q2);
                    ps2.setString(1,tf.getText());
                    ps2.executeUpdate();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Vehicle not found. Try again.","NF.exe",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
