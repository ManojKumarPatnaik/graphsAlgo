package com.magadistudio.flashcard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;


public class FlashCardBuilder {
	
	//Instance variables
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<FlashCard> cardList;
	private JFrame frame;

	

	public FlashCardBuilder() {
		
		//Setup UI
		frame = new JFrame("Flash Card");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create a JPanel to hold everything
		JPanel mainPanel = new JPanel();
		
		//Font
		Font greatFont = new Font("Helvetica Neue", Font.BOLD, 22);
		question = new JTextArea(6, 20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(greatFont);
		
		
		//JscrollPane ( make it all scrollable )
		JScrollPane qJScrollPane = new JScrollPane(question);
		qJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		//Answer area
		answer = new JTextArea(6, 20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(greatFont);

		//ScrollPane for Answer area
		JScrollPane aJScrollPane = new JScrollPane(answer);
		aJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		
		cardList = new ArrayList<FlashCard>(); //create an arrayList of Quizcards objects
		
		
		//Create a few labels
		JLabel qJLabel = new JLabel("Question");
		JLabel aJLabel = new JLabel("Answer");
		
		
		// Add components to mainPanel
		mainPanel.add(qJLabel);
		mainPanel.add(qJScrollPane);
		mainPanel.add(aJLabel);
		mainPanel.add(aJScrollPane);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		//MenuBar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		
		saveMenuItem.addActionListener(new SaveMenuListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
	
		
		
		
		
		//Add to the Frame
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);
		
		
		
		 
	}

	public static void main(String[] args) {
		
		// Create the frame on the event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new FlashCardBuilder();
				
			}
		});


	}
	
	
	public class NextCardListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
   		FlashCard card = new FlashCard(question.getText(), answer.getText());
			cardList.add(card);
			clearCard();
			
			
		}
		
	}
	
	public class SaveMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			FlashCard card = new FlashCard(question.getText(), answer.getText());
			cardList.add(card);
			
			//Create a file dialog with file chooser, all done for us!
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
			
		}

	}
	
	public class NewMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardList.clear();
			clearCard();
			
		}
	}

	public void clearCard(){
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}

	private void saveFile(File selectedFile) { // This is where the writing to file happens
		
		try {
			
			//We'll use BufferedWriter Class for efficiency reasons
			BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
			
			Iterator<FlashCard> cardIterator = cardList.iterator();
			while (cardIterator.hasNext()) {
				FlashCard card = (FlashCard)cardIterator.next();
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
				
			}
			
			
//			for (FlashCard card : cardList) {
//				writer.write(card.getQuestion() + "/");
//				writer.write(card.getAnswer() + "\n");
//			}
			writer.close(); // need to always close when done!
			
		} catch (IOException e) {
			System.out.println("Couldn't write to file");
			e.printStackTrace();
		}
		
		
	}
}
