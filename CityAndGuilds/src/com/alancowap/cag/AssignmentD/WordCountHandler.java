/** 
 *  
 * Sample answer to City & Guilds "Diploma in Software Development" Level 2
 * Unit 205 - Assignment D  
 *  
 * @author Alan Cowap 
 * @version 1.0  
 * @dependencies None
 *  
 */

package com.alancowap.cag.AssignmentD;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 * This class implements the functionality of the Word Count applet
 * As an exercise can you
 * 		a) modify the scope of searchArea and derived variables (they are used locally in several methods)
 * 		b) add new methods to carry out frequently performed tasks (e.g. parsing the SearchArea)
 * 		c) modify existing methods to use your new methods from part (b)
 * 		d) use Constants where appropriate, rather than variables e.g. String literals 
 *
 */
public class WordCountHandler implements ActionListener{

	private WordCountGui gui;

	public WordCountHandler(WordCountGui gui){
		this.gui =  gui;
	}	

	/**
	 * This callback method is executed when user has clicked a Button we are listening to.
	 */
	public void actionPerformed(ActionEvent evt){
		String command = evt.getActionCommand();
		
		if(command.equals("Find Word")){
			findWord();
		}else if(command.equals("Word Count")){
			this.startWordCount();
		}else if(command.equals("Clear")){
			this.clearAllFields();
		}
	}
	
	
	/**
	 * Clear all TextAreas & TextFields in the GUI
	 */
	private void clearAllFields(){
		gui.txtSearchArea.setText("");
		gui.txtEnterWord.setText("");
		gui.txtNumWords.setText("");
		gui.txtNumChars.setText("");
		gui.txtNumCharsNoSpaces.setText("");
		gui.txtNumParas.setText("");
		gui.txtStatus.setText("");		
	}
	
	
	/**
	 * Controlling method that calls several methods to do Word etc. count on TextArea
	 */
	private void startWordCount(){
		String searchArea = gui.txtSearchArea.getText();
		if(null == searchArea || searchArea.equals("")){
			return; // do nothing if TextArea is empty (or null)
		}	
		countNumWords();
		countNumChars();
		countNumCharsNoWSpace();
		countNumParagraphs();
	}
	
	/**
	 * Count the number of words in the Search area
	 */
	private void countNumWords(){
		String searchArea = gui.txtSearchArea.getText();	
		String [] searchAreaLineArray = searchArea.split("\n");
		String [] searchAreaWordArray = searchArea.split(" ");
		
		int totNumWords = searchAreaLineArray.length + searchAreaWordArray.length -1;
		gui.txtNumWords.setText(""+totNumWords);
	}
	
	
	/**
	 * Count the number of chars in the Search area
	 */ 
	private int countNumChars(){
		String searchArea = gui.txtSearchArea.getText();
		int totalChars = searchArea.length()+1;
		
		//Newlines do not count as characters (in this case)
		String [] searchAreaLineArray = searchArea.split("\n");
		totalChars -= searchAreaLineArray.length;
		
		gui.txtNumChars.setText(""+totalChars);
		return totalChars;
	}


	/**
	 * Count the number of chars in the Search area, not including whitespaces
	 */ 
	private void countNumCharsNoWSpace(){
		String searchArea = gui.txtSearchArea.getText();
		int totNumChars = this.countNumChars();
		
		for (char ch : searchArea.toCharArray()){
			if (Character.isWhitespace(ch))
				totNumChars--;
		}
		gui.txtNumCharsNoSpaces.setText(""+ totNumChars);		
	}


	/**
	 * Count the number of paragraphs in the Search area
	 */ 
	private void countNumParagraphs(){
		String searchArea = gui.txtSearchArea.getText();
		String[] searchAreaLineArray = searchArea.split("\n");
		int numParagraphs = searchAreaLineArray.length;
		gui.txtNumParas.setText(""+numParagraphs);
	}


	/**
	 * Find the search word in the search area, highlight if found
	 */
	private void findWord(){
		String searchArea = gui.txtSearchArea.getText();	
		String searchWord = gui.txtEnterWord.getText();
		
		if(searchArea.equals("") || searchWord.equals("")){
			return; // do nothing if either search field is empty
		}		

		//Remove previous highlighting
		Highlighter hilite = gui.txtSearchArea.getHighlighter();
		hilite.removeAllHighlights();
		
		//Split the Search area into individual lines
		String [] searchAreaArray = searchArea.split("\n");
		int matchIndex = -1;
		boolean matchFound = false;
		int totalChars = 0;
		
		// Find the index of the word, on the current line
		for(int i = 0; i < searchAreaArray.length;i++ ){
			matchIndex = searchAreaArray[i].indexOf(searchWord);
			if(matchIndex != -1 ){
				matchFound = true;
				gui.txtStatus.setForeground(Color.BLUE);
				gui.txtStatus.setText("Word found at:"+ (totalChars + matchIndex));
				//Highlight the word, when found
				try {
					hilite.addHighlight(totalChars+matchIndex, totalChars + matchIndex + searchWord.length(), DefaultHighlighter.DefaultPainter);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
						
				break; //we found a match, so we're finished searching
			}
			totalChars += searchAreaArray[i].length() +1; //+1 to allow for CRLF character at end of each line in TextArea
		}
		if(!matchFound){
			gui.txtStatus.setForeground(Color.RED);
			gui.txtStatus.setText("Word not found");
		}
	}

}
