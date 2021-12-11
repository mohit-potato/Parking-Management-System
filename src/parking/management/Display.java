package parking.management;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Display extends JFrame {
    JTable table = new JTable(30,5);

    Display(){
        //frame
        this.setSize(500,400); //sets x & y dim
        this.setTitle("Display.exe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true); //make frame visible
        ImageIcon icon = new ImageIcon("F:\\Java\\ParkingSystem\\lib\\car2.jpg"); //creating an image object
        this.setIconImage(icon.getImage());//setting the image to frame

        try {
            Connection con = Connector.createC();
            String q = "select numberplate as VehicleNumber,vehicletype as VehicleType,model as Model,color as Color,time as Time from parking;";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(0,0,500,400);
            table.setEnabled(false);
            this.add(sp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
