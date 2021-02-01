/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourism.offices.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddHotel extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddHotel().setVisible(true);
    }


    public AddHotel() {
        setBounds(220, 200, 960, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("tourism/offices/system/icons/twelve2.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Add Hotel");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
        
	JLabel l1 = new JLabel("Hotel Name");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t4 = new JTextField();
	t4.setBounds(174, 70, 156, 20);
	contentPane.add(t4);
        

	JLabel l2 = new JLabel("Address");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        t3 = new JTextField();
	t3.setBounds(174, 110, 156, 20);
	contentPane.add(t3);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        t2 = new JTextField();
	t2.setBounds(174, 190, 156, 20);
	contentPane.add(t2);

        JLabel l5 = new JLabel("Rating");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "1 star", "2 star", "3 star", "4 star", "5 star"});
	comboBox_3.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox_3);
        
        JLabel l6 = new JLabel("Rooms");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 270, 102, 22);
	contentPane.add(l6);
        
        t1 = new JTextField();
	t1.setBounds(174, 270, 156, 20);
	contentPane.add(t1);

        
	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn c = new conn();
                String hotel_name = t4.getText();
                String address = t3.getText();
                String price  = t2.getText();
                String rating = (String)comboBox_3.getSelectedItem();
                String rooms  = t1.getText();
                String str = "INSERT INTO hotels values( '"+hotel_name+"', '"+address+"', '"+price+"', '"+rating+"', '"+rooms+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Hotel Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                new Reception().setVisible(true);
                setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
