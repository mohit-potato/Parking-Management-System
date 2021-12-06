package parking.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Add extends JFrame implements ActionListener {
    JButton b;
    JTextField tf;
    JTextField tf3;
    JTextField tf4;
    JTextField tf5;
    JComboBox cb;

    Add(){
        //button
        b = new JButton();
        b.setText("Add");
        b.setBounds(190,300,100,20);
        b.addActionListener(this);
        b.setFocusable(false);
        this.add(b);

        //combobox
        String [] vt={"Two-wheeler","Four-wheeler"};
        cb = new JComboBox(vt);
        cb.addActionListener(this);
        cb.setBounds(170,80,200,20);
        this.add(cb);

        //labels
        JLabel l= new JLabel("Vehicle Number :");
        JLabel l2= new JLabel("Vehicle Type :");
        JLabel l3= new JLabel("Model :");
        JLabel l4= new JLabel("Color :");
        JLabel l5= new JLabel("Time (hrs) :");
        l.setBounds(60,30,100,20);
        l2.setBounds(60,80,100,20);
        l3.setBounds(60,130,100,20);
        l4.setBounds(60,180,100,20);
        l5.setBounds(60,230,100,20);
        this.add(l);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);

        //textfields
        tf = new JTextField(20);
        tf3 = new JTextField(20);
        tf4 = new JTextField(20);
        tf5 = new JTextField(20);
        tf.setBounds(170,30,200,20);
        tf3.setBounds(170,130,200,20);
        tf4.setBounds(170,180,200,20);
        tf5.setBounds(170,230,200,20);
        this.add(tf);
        this.add(tf3);
        this.add(tf4);
        this.add(tf5);

        //frame
        this.setSize(500,400); //sets x & y dim
        this.setTitle("ADD.exe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true); //make frame visible
        ImageIcon icon = new ImageIcon("C:\\Users\\mohit\\Downloads\\Image & Memey Stuff\\car2.jpg"); //creating an image object
        this.setIconImage(icon.getImage()); //setting the image to frame
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b) {
            try{
                Connection con = Connector.createC();

                String q = "insert into parking (numberplate,vehicletype,model,color,time) values (?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1,tf.getText());
                ps.setString(2, (String) cb.getSelectedItem());
                ps.setString(3,tf3.getText());
                ps.setString(4,tf4.getText());
                ps.setInt(5, Integer.parseInt(tf5.getText()));

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Vehicle details added successfully.","DA.exe",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
