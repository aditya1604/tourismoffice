/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourism.offices.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TourismOfficesSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public TourismOfficesSystem() {
		
                setSize(800,430);          // setContentPane(300,300,1366,390);   frame size
                setLayout(null);
                setLocation(300,200);

		l1 = new JLabel("");
                b1 = new JButton("Next");
                
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
				
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("tourism/offices/system/icons/first.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1000, 395,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                JLabel lid=new JLabel("Tourism Offices");
                lid.setBounds(120,90,1500,100);
                lid.setFont(new Font("serif",Font.PLAIN,50));
                lid.setForeground(Color.red);
                l1.add(lid);
                
                b1.setBounds(420,325,150,50);
		l1.setBounds(0, 0, 1000, 390);
                
                l1.add(b1);
		add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	}
        
        public void actionPerformed(ActionEvent ae){
                new Reception().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                TourismOfficesSystem window = new TourismOfficesSystem();
                window.setVisible(true);			
	}
}
