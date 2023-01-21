package com.magadistudio.flashcard;

import java.awt.BorderLayout;
import java.awt.Font;
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
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;
	
	
	
	
	public FlashCardPlayer() {
		
		// Build UI
		frame = new JFrame("Flash Card Player");
		JPanel mainPanel = new JPanel();
		Font mFont = new Font("Helvetica Neue", Font.BOLD, 23);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display = new JTextArea(10, 20);
		display.setFont(mFont);
		
		JScrollPane qJScrollPane = new JScrollPane(display);
		qJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Answer");
		mainPanel.add(qJScrollPane);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load Card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640, 500);
		frame.setVisible(true);
	}
	
	
	public static void main (String[] args) {
		// Create the frame on the event dispatching thread
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new FlashCardPlayer();
						
					}
				});

	}
	
	
	public class NextCardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(isShowAnswer) {
				// Show the answer since they've seen the question
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}else {
				// show next question
				if (cardIterator.hasNext()) {
					
					//we know our arraylist of cards is not empty, so show next card
					showNextCard();
				}else {
					
					// no more cards to show
					display.setText("That was last card.");
					nextButton.setEnabled(false);
					
				}
			}
			
		}

		
		
	}
	
	public class OpenMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
			
		}
		
	}
	
	public void loadFile(File file) {
		
		cardList = new ArrayList<FlashCard>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while (( line = reader.readLine()) != null) {
				makeCard(line);
			}
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Couldn't read the card file");
			e.printStackTrace();
		}
		
		// show the first card
		cardIterator = cardList.iterator();
		showNextCard();
		
		
	}
	
	public void makeCard(String lineToParse) {
		//String[] result = lineToParse.split("/");
		StringTokenizer result = new StringTokenizer(lineToParse, "/");
		if (result.hasMoreTokens()) {
			
			FlashCard card = new FlashCard(result.nextToken(), result.nextToken());
			cardList.add(card);
			System.out.println("Made a Card" + card.getQuestion());
			
			
		}
		
	}
	
	
	private void showNextCard() {
		
			currentCard = (FlashCard) cardIterator.next();
			
			
			display.setText(currentCard.getQuestion());
			nextButton.setText("Show Answer");
			isShowAnswer = true;
			
		
	}
	

}
