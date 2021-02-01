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

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchHotel extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private final JPanel contentPane;
	//private JTextField txt_Type;
	private JTable table;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchHotel frame = new SearchHotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public SearchHotel() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 120, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchForHotel = new JLabel("Search For Hotel");
		lblSearchForHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForHotel.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForHotel);
                
                JLabel lblHotelRating = new JLabel("Hotel Rating:");
		lblHotelRating.setBounds(20, 73, 96, 14);
		contentPane.add(lblHotelRating);
		
		JLabel lblHotelName = new JLabel("Hotel Name:");
		lblHotelName.setBounds(7, 162, 96, 14);
		contentPane.add(lblHotelName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(140, 162, 96, 14);
		contentPane.add(lblAddress);
		
		JLabel lblRoomAvailable = new JLabel("Rooms Available");
		lblRoomAvailable.setBounds(560, 162, 96, 14);
		contentPane.add(lblRoomAvailable);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(290, 162, 96, 14);
		contentPane.add(lblPrice);
                
                JLabel lblRating_2 = new JLabel("Rating");
		lblRating_2.setBounds(420, 162, 96, 14);
		contentPane.add(lblRating_2);
		
		/*JCheckBox checkService = new JCheckBox("Only display with Pick up service");
		checkService.setBounds(300, 69, 205, 23);
                checkService.setBackground(Color.WHITE);
		contentPane.add(checkService);*/
		
		
                c1 = new Choice();
                c1.add("1 star");
                c1.add("2 star");
                c1.add("3 star");
                c1.add("4 star");
                c1.add("5 star");
                c1.setBounds(153, 70, 120, 20);
		contentPane.add(c1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "select * from hotels where rating = '"+c1.getSelectedItem()+"'";
                               // String SQL2 = "select * from hotels where pick_up = 'Available' AND rating = '"+c1.getSelectedItem()+"'";
			try{			
                                conn c = new conn();
				rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				/*if(checkService.isSelected())
				{	
					rs = c.s.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}*/
				
				
			}catch (SQLException ss)
			{
				ss.printStackTrace();
			}
			
			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		contentPane.add(table);
                
                getContentPane().setBackground(Color.WHITE);
	}
}