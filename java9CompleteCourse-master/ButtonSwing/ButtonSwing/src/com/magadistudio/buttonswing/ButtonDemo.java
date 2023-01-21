package com.magadistudio.buttonswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class ButtonDemo implements ActionListener {

	JLabel myLabel;
	
	public ButtonDemo() {
		
		// Create a Jframe
		JFrame jFrame = new JFrame("Button");
		
		// Specify FlowLayout for the layout manager
		jFrame.setLayout(new FlowLayout());
		
		//Give a size to our frame
		jFrame.setSize(220, 80);
		
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Make a button
		JButton upButton = new JButton("Up");
		JButton downButton = new JButton("Down");
		

		//Label
		myLabel = new JLabel("Press Button");
		

		
		//Add EventListeners
		upButton.addActionListener(this);
		downButton.addActionListener(this);
		
//		upButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//Do the action needed
//				System.out.println("Hello Up clicked");
//				
//			}
//		});
//		
//		downButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				 System.out.println("Hello Down Clicked");
//				
//			}
//		});
		
		
		
		
		jFrame.add(upButton);
		jFrame.add(downButton);
		jFrame.add(myLabel);
		
		
		
		
		//Show it!
		jFrame.setVisible(true);
		
		
				
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Our playground
		
		if (e.getActionCommand().equals("Up")) {
				
			myLabel.setText("You pressed Up" );
		}else {
			myLabel.setText("You pressed Down");
		}
		
		
	}

	

	public static void main(String[] args) {
		// Create the frame on the event dispatching thread
					SwingUtilities.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							new ButtonDemo();
							
						}
					});

	}

	
}
