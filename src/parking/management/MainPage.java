package parking.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame implements ActionListener {
    JButton button;
    JButton button2;
    JButton button3;
    JButton button4;

    MainPage() {
        //images
        ImageIcon icon = new ImageIcon("F:\\Java\\ParkingSystem\\lib\\car.png");//creating an image object
        ImageIcon icon2 = new ImageIcon("F:\\Java\\ParkingSystem\\lib\\car2.jpg");

        //button
        button = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button.setText("Add Entry");
        button2.setText("Generate Bill");
        button3.setText("Display Entries");
        button4.setText("Exit");
        button.setBounds(300,150,120,30);
        button.addActionListener(this);
        button.setFocusable(false);
        button2.setBounds(300,200,120,30);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button3.setBounds(300,250,120,30);
        button3.addActionListener(this);
        button3.setFocusable(false);
        button4.setBounds(210,320,57,21);
        button4.addActionListener(this);
        button4.setFocusable(false);
        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);

        //label
        JLabel label = new JLabel("WELCOME TO OUR PARKING MANAGEMENT SYSTEM");
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel("Add a vehicle to database  >>");
        JLabel label4 = new JLabel("Release vehicle & generate bill  >>");
        JLabel label5 = new JLabel("Display vehicles in database  >>");
        label.setFont(new Font("Uni Sans Heavy CAPS",Font.PLAIN,17));
        label3.setFont(new Font("Bahnschrift SemiBold SemiConden",Font.ITALIC,14));
        label4.setFont(new Font("Bahnschrift SemiBold SemiConden",Font.ITALIC,14));
        label5.setFont(new Font("Bahnschrift SemiBold SemiConden",Font.ITALIC,14));
        label.setBounds(40,10,500,70);
        label2.setIcon(icon);
        label2.setBounds(185,50,100,100);
        label3.setBounds(50,150,300,30);
        label4.setBounds(47,200,300,30);
        label5.setBounds(50,250,300,30);
        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);

        //frame
        this.setSize(500,400); //sets x & y dim
        this.setTitle("PMS.exe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true); //make frame visible
        this.setIconImage(icon2.getImage()); //setting the image to frame
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==button) {
            new Add();
        }
        if(ae.getSource()==button2) {
            new GenerateBill();
        }
        if(ae.getSource()==button3) {
            new Display();
        }
        if(ae.getSource()==button4) {
            JOptionPane.showMessageDialog(null,"Thank you for using our program.","TY.exe",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }
    public static void main(String[] args) {
        new MainPage();
    }
}
