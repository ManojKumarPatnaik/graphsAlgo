package com.magadistudio.flashcards.app;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class FlashCardPlayer {
	
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<FlashCard> cardList;
	private Iterator cardIterator;
	private FlashCard currentCard;
	private int currentCardIndex;
	private JButton showAnswer;
	private JFrame frame;
	private boolean isShowAnswer;
	
	
	
	public FlashCardPlayer() {
		
		// Build UI
		frame = new JFrame("Flash Card Player");
		JPanel mainPanel = new JPanel();
		Font mFont = new Font("Helvetica Neue", Font.BOLD, 22);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display = new JTextArea(10, 20);
		display.setFont(mFont);
		
		JScrollPane qJScrollPane = new JScrollPane(display);
		qJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		showAnswer = new JButton("Show Answer");
		
		mainPanel.add(qJScrollPane);
		mainPanel.add(showAnswer);
		showAnswer.addActionListener(new NextCardListener());
		
		// Add Menu
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load Card Set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		
		
		
		// Add to frame
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640, 500);
		frame.setVisible(true);
		
	}
	
	
	
	

	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new FlashCardPlayer();
				
			}
		});
	}
	
	
	class NextCardListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (isShowAnswer) {
				display.setText(currentCard.getAnswer());
				showAnswer.setText("Next Card");
				isShowAnswer = false;
				
			} else {
				
				//show next question
				 if (cardIterator.hasNext()) {
					 
					 showNextCard();
					
				} else {
					//no more cards
					display.setText("That was last card.");
					showAnswer.setEnabled(false);
				}
			}
			
			
		}
		
	}
	
	class OpenMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}

		
		
	}
	
	private void loadFile(File selectedFile) {
		
		cardList = new ArrayList<FlashCard>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				makeCard(line);
			}
			
		} catch (Exception e) {
			System.out.println("Couldn't read file");
			e.printStackTrace();
		}
		
		//show the first card
		cardIterator = cardList.iterator();
		showNextCard();
	}






	private void makeCard(String lineToParse) {
		
		StringTokenizer result = new StringTokenizer(lineToParse, "/");
		
		if (result.hasMoreTokens()) {
			FlashCard card  = new FlashCard(result.nextToken(), result.nextToken());
			cardList.add(card);
			System.out.println("Made a Card");
			
		}
		
//		String[] result = lineToParse.split("/"); // [question,answer]
//		
//		FlashCard card  = new FlashCard(result[0], result[1]);
//		cardList.add(card);
//		System.out.println("Made a Card");
		

		
	}
	


	private void showNextCard() {
		currentCard = (FlashCard) cardIterator.next();
		
		display.setText(currentCard.getQuestion());
		showAnswer.setText("Show Answer");
		isShowAnswer = true;
		
	}

}


