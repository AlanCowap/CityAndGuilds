/** 
 *  
 * Sample answer to City & Guilds "Diploma in Software Development" Level 2
 * Unit 205 - Assignment A  
 *  
 * @author Alan Cowap 
 * @version 1.0  
 * @dependencies None
 *  
 */

package com.alancowap.cag.AssignmentA;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * This class is the Swing GUI for the hangman game
 */
public class GuessWordGui extends JPanel {

	// Instance variables
	private JLabel guessTheWord = new JLabel("GUESS THE WORD", JLabel.RIGHT);	// Right justified
	private JTextField guessText = new JTextField(24);	// Should be 24 characters long
	private JLabel guessesRemainingLbl = new JLabel("GUESSES REMAINING", JLabel.RIGHT);	// Right justified
	private JTextField guessesRemaining = new JTextField(3);	// Should be 3 characters long
	private JButton[] buttons = new JButton[28]; // Array of JButtons for GUI
	

	// Constructor
	public GuessWordGui() {
		this.setLookAndFeel();		
		this.createButtons();
		this.addListenersToButtons();
		this.setupGui();
	}
	
	public void setGuessText(String guess){
		this.guessText.setText(guess);
	}
	
	public void setGuessesRemaining(String guess){
		this.guessesRemaining.setText(guess);
	}
	
	
	/**
	 * Create JButtons for 26 letters of the alphabet, and the START and ANSWER JButtons
	 */
	private void createButtons(){
		char ch = 'A';
		for(int i=0; i < 26; i++){
			buttons[i] = new JButton(Character.toString(ch++));
		}
		buttons[26] = new JButton("START");
		buttons[27] = new JButton("ANSWER");
	}
	
	
	/**
	 * Add listeners to our Buttons
	 */
	private void addListenersToButtons(){
		// Create an instance of our ActionListener subclass i.e. GuessWordHandler
		GuessWordHandler gwh = new GuessWordHandler(this);
		//and add the listener to all of our JButtons
		for(JButton b : buttons){
			b.addActionListener(gwh);
		}		
	}
	
	/**
	 * Add Buttons to our Panel
	 * @param panel the panel to which we want to add Buttons
	 */
	private void addButtonsToPanel(JPanel panel){
		for(JButton b : buttons){
			panel.add(b);
		}		
	}
	

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
	
	private void setupGui(){
		guessText.setHorizontalAlignment(JTextField.RIGHT);
		guessesRemaining.setHorizontalAlignment(JTextField.RIGHT);

		GridLayout mainLayout = new GridLayout(2, 1, 100, 0);
		setLayout(mainLayout);

		// Panel for top part of GUI, comprising Labels and Textfields 
		JPanel topPanel = new JPanel(); 
		topPanel.setBorder(BorderFactory.createEmptyBorder(50, 400,50,50));
		FlowLayout flo = new FlowLayout(FlowLayout.RIGHT); 
		topPanel.setLayout(flo);
		guessTheWord.setForeground(Color.RED);	// Should be red text
		topPanel.add(guessTheWord);
		topPanel.add(guessText);
		guessText.setEditable(false);	// Should not be editable
		guessesRemainingLbl.setForeground(Color.RED);	// Should be red text
		topPanel.add(guessesRemainingLbl);
		topPanel.add(guessesRemaining);
		guessesRemaining.setEditable(false);
		this.add(topPanel);

		// Panel for bottom part of GUI, comprising Buttons
		JPanel bottomPanel = new JPanel(); 
		bottomPanel.setLayout(new GridLayout(4, 7, 0, 15));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));		
		this.addButtonsToPanel(bottomPanel);		
		add(bottomPanel);
		
		// Display the GUI
		setVisible(true);
	}

}
