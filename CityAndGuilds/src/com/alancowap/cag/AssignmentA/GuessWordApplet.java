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

import javax.swing.JApplet;

/**
 * This class is the Applet GUI for the hangman game.
 * It specifies the Applet size, and displays a SwingGUI inside the Applet.
 * 
 */
public class GuessWordApplet extends JApplet {

	// Constructor
	public GuessWordApplet() {
		setContentPane(new GuessWordGui());
	}
	
	/**
	 * Initialise the Applet
	 */
	@Override
	public void init(){
		setSize(700,500);
	}

}
