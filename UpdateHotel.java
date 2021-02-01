/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourism.offices.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateHotel extends JFrame {
Connection conn = null;
PreparedStatement pst = null;
	private JPanel contentPane;
	//private JTextField txt_ID;
	private JTextField txt_Name;
	private JTextField txt_Address;
        private JTextField txt_Price;
        private JTextField txt_Rating;
        private JTextField txt_Rooms;
	private JTextField txt_Room;
        
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateHotel frame = new UpdateHotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UpdateHotel() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 140, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("tourism/offices/system/icons/third.jpg"));
                Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,80,600,250);
                add(l1);
		
		JLabel lblUpdateHotelStatus = new JLabel("Update Hotel Status");
		lblUpdateHotelStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateHotelStatus.setBounds(85, 11, 206, 34);
		contentPane.add(lblUpdateHotelStatus);
		
		JLabel lblNewLabel = new JLabel("Hotel Name:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from hotels");
                    while(rs.next()){
                        c1.add(rs.getString("hotel_name"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(27, 114, 90, 14);
		contentPane.add(lblAddress);
                
                JLabel lblName = new JLabel("Hotel Name");
		lblName.setBounds(27, 144, 90, 14);
		contentPane.add(lblName);
                
                JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(27, 174, 90, 14);
		contentPane.add(lblPrice);
                
                JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(27, 204, 90, 14);
		contentPane.add(lblRating);
                
                JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setBounds(27, 234, 90, 14);
		contentPane.add(lblRooms);
                
                txt_Address = new JTextField();
		txt_Address.setBounds(160, 112, 140, 20);
		contentPane.add(txt_Address);
		txt_Address.setColumns(10);
                
                txt_Price = new JTextField();
		txt_Price.setBounds(160, 172, 140, 20);
		contentPane.add(txt_Price);
		txt_Price.setColumns(10);
		
		txt_Rating = new JTextField();
		txt_Rating.setBounds(160, 202, 140, 20);
		contentPane.add(txt_Rating);
		txt_Rating.setColumns(10);
                
                txt_Rooms = new JTextField();
		txt_Rooms.setBounds(160, 232, 140, 20);
		contentPane.add(txt_Rooms);
		txt_Rooms.setColumns(10);
                
                txt_Name = new JTextField();
		txt_Name.setBounds(160, 142, 140, 20);
		contentPane.add(txt_Name);
		txt_Name.setColumns(10);

                JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
                                //String s1 = c1.getSelectedItem();
				conn c = new conn();
                                String SQL = "select * from hotels where hotel_name = '"+c1.getSelectedItem()+"'";
                                ResultSet rs1 = c.s.executeQuery(SQL);
                                
                                while(rs1.next()){
                                    txt_Name.setText(rs1.getString("hotel_name"));
                                    txt_Address.setText(rs1.getString("address"));
                                    txt_Rating.setText(rs1.getString("rating"));
                                    txt_Price.setText(rs1.getString("price"));
                                    txt_Rooms.setText(rs1.getString("rooms"));
                                }
                            }catch(Exception ee){}
                            try{
                                conn c  = new conn();
                                ResultSet rs2 = c.s.executeQuery("select * from hotels where hotel_name = "+txt_Name.getText());
                                while(rs2.next()){
                                    txt_Address.setText(rs2.getString("address"));
                                    txt_Name.setText(rs2.getString("hotel_name"));
                                    txt_Rating.setText(rs2.getString("rating"));
                                    txt_Price.setText(rs2.getString("rrice"));
                                    txt_Rooms.setText(rs2.getString("rooms"));
                                }
                            }catch(Exception ee){}
                        }
		});
		b1.setBounds(120, 315, 89, 23);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				
				try{
                                    conn c = new conn();
                                    
                                    String hotel_name = txt_Name.getText();
                                    String address = txt_Address.getText();
                                    String price = txt_Price.getText();
                                    String rating = txt_Rating.getText();
                                    String rooms = txt_Rooms.getText();
                                    String str = "update hotels set '"+hotel_name+"', '"+price+"', '"+address+"', '"+rating+"', '"+rooms+"' where hotel_name = '"+hotel_name;
                                    c.s.executeUpdate(str);
                                    JOptionPane.showMessageDialog(null, "Update Sucessful");
                                    
                                    new Reception().setVisible(true);
                                    setVisible(false);
				}catch (Exception ee){
					ee.printStackTrace();
				}
				
			
			}
		});
		btnUpdate.setBounds(60, 355, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(180, 355, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		getContentPane().setBackground(Color.WHITE);
	}

}