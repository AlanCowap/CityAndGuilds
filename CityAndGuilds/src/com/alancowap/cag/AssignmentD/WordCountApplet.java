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

import javax.swing.JApplet;

public class WordCountApplet extends JApplet {

	/**
	 * Create the applet.
	 */
	public WordCountApplet() {
		setContentPane(new WordCountGui());
	}
	
	/**
	 * Initialise the Applet
	 */
	@Override
	public void init(){
		setSize(570,400);
	}


}
