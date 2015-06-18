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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This class implements the functionality for the Hangman Game
 *
 */
public class GuessWordHandler implements ActionListener{

	// Instance variables
	GuessWordGui gui;		// reference to the main GUI
	String [] gameDictionary = {"MEMORY", "COMPUTER", "PRINTER", "TROUSERS", "BUTTERCUP"};
	// You can change the words to guess, but this is not required for the C&G exam
//	String [] gameDictionary = {"TRANSIENT", "VOLATILE", "ABSTRACT", "FINAL", "VOID", "VARIABLE", "CLASS", "EXCEPTION",
//			"NULLPOINTEREXCEPTION", "PACKAGE", "OBJECT", "IMPORT", "COMPILER", "STACKOVERFLOW", "CONSTRUCTOR", "SUPER"};
	String gameWord = "";	// current word to be guessed
	String holdWord = "";	// current guessword of the player
	int lives = 8;			// lives the player has remaining (must be 8 lives)
	int counter = 0;		// keep track of count through the guess word array

	// Constructor 
	public GuessWordHandler(GuessWordGui gui) {
		this.gui = gui;
	}


	/**
	 * Called when a button, which we are 'listening' to, has been clicked by the user
	 */
	public void actionPerformed(ActionEvent event) {

		if(event.getActionCommand().equals("START")) {
			this.startGame();
		} 
		else if(event.getActionCommand().equals("ANSWER")) {
			this.displayAnswer();
		} else {
			this.evaluateChoice(event.getActionCommand());
		}
	}
	
	/**
	 * Start playing the Game
	 */
	private void startGame(){
		// Choose the relevant word from the dictionary
		gameWord = gameDictionary[counter % gameDictionary.length];
		counter++;
		lives = 8;
		holdWord = gameWord;

		// Mask the word
		for(int i = 0; i < holdWord.length(); i++){
			holdWord = holdWord.replace(holdWord.charAt(i), '*');
		}

		gui.setGuessText(holdWord);
		gui.setGuessesRemaining("" + lives);
	}
	
	/**
	 * Display the Answer.
	 * You must display answer if the Answer button is selected.
	 */
	private void displayAnswer(){
		gui.setGuessText(gameWord);
		gui.setGuessesRemaining("");
	}
	
	/**
	 * Evaluate the users choice
	 * @param letter represents whichever letter the user chose
	 */
	private void evaluateChoice(String letter){
		if(gameWord.indexOf(letter) != -1) {	//the letter is in the gameWord
			//loop through the gameWord 
			for(int i = 0; i < gameWord.length(); i++) {
				//check each letter in gameWord and store the letter in currentLetter
				String currentLetter = "" + gameWord.charAt(i);

				if(currentLetter.equals(letter)) {
					// modify holdword to include the matched letter (replacing the '*')
					holdWord = holdWord.substring(0, i) + letter + holdWord.substring(i + 1); 
					gui.setGuessText(holdWord);
				}
			}
			
			if(gameWord.equals(holdWord)) { // If the word has been guessed correctly
				JLabel youWin = new JLabel("You Win");
				youWin.setFont(new Font(youWin.getFont().getFontName(), Font.PLAIN, 20));
				youWin.setForeground(Color.BLUE);
				JOptionPane.showMessageDialog(null, youWin);
			}

		}else {	//the letter is NOT in the gameWord
			lives--;
			gui.setGuessesRemaining("" + lives);
			if (lives <= 0) {
				JLabel youLose = new JLabel("You Lose");
				youLose.setFont(new Font(youLose.getFont().getFontName(), Font.PLAIN, 20));
				youLose.setForeground(Color.RED);
				JOptionPane.showMessageDialog(null, youLose);
			}
		}		
	}

}
