package com.magadistudio.SwingDemo;
import java.awt.FlowLayout;

import javax.swing.*;

public class SwingDemo {

	 public SwingDemo() {
		
		 // Create a new JFrame container
		 JFrame jFrame = new JFrame("First Swing Application");
		 		 

		 
		 // Give it a size
		 jFrame.setSize(275, 100);
		 
		 // Terminate the program when the user closes the application
		 jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 
		 // Create a JLabel 
		 JLabel jLabel = new JLabel("Wow this is amazing!");
		
		 		 
		 // Add to the frame
		 jFrame.add(jLabel);
		 
		
		 
		 //Show it
		 jFrame.setVisible(true);
		 
		 
		 
		 
	}
		
	
	

		public static void main(String[] args) {
			// Create the frame on the event dispatching thread
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new SwingDemo();
					
				}
			});
			
			
	    }
			

}
