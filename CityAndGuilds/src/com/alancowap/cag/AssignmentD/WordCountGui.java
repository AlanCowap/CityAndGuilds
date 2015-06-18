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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Class describing the GUI for the WordCount app 
 * 
 * As an exercise can you
 * 		a) Run the code and see if it works
 *			- use Test Data, Test plan, Test log, Test Report if you like
 *		b) Consider the Access modifiers of the following instance variables and change them as appropriate
 *			- you may need to add getters/setters ifeverything is private.
 *		c) Consider the scope of the instance variables, and reduce them as appropriate.
 *		d) Could the layout be improved? What happens when you maximise the window?
 *
 */
public class WordCountGui extends JPanel {
	
	private WordCountHandler handler = new WordCountHandler(this);
	// Create components for the applet.
	JPanel pnlCenter = new JPanel();
	JLabel lblEnterText = new JLabel("Enter text");
	JTextArea txtSearchArea = new JTextArea(8,35);
	
	JPanel pnlCenter2 = new JPanel();
	JPanel pnlCenter3 = new JPanel();
	JLabel lblNumWordsAndChars = new JLabel("Count of words and characters");
	JLabel lblNumWords = new JLabel("Number of words");
	JLabel lblNumChars = new JLabel("Number of characters including spaces");
	JLabel lblNumCharsNoSpaces = new JLabel("Number of characters without spaces");
	JLabel lblNumParas = new JLabel("Number of paragraphs");
	
	
	JPanel pnlCenter4 = new JPanel(); 
	JTextField txtNumWords = new JTextField(4);
	JTextField txtNumChars = new JTextField(4);
	JTextField txtNumCharsNoSpaces = new JTextField(4);
	JTextField txtNumParas = new JTextField(4);
	
	JPanel pnlEast = new JPanel();
	JPanel pnlEast2 = new JPanel();
	JLabel lblEnterWord = new JLabel ("Enter Word");
	JTextField txtEnterWord = new JTextField(15);
	JLabel lblStatus = new JLabel("Status");
	JTextField txtStatus = new JTextField(15);
	
	JPanel pnlEast3 = new JPanel();
	JButton btnFindWord = new JButton("Find Word");
	JButton btnClear = new JButton("Clear");
	
	JPanel pnlEast4 = new JPanel();
	JButton btnWordCount = new JButton("Word Count");
	
 
	/**
	 * Constructor
	 */
	public WordCountGui(){	
		this.setUpGui();
	}
	
	
	/**
	 * Sets up all the components of the GUI
	 */
	private void setUpGui(){
		
		// Sets color of the background and foreground of applet.
		pnlCenter.setBackground(Color.LIGHT_GRAY);
		pnlCenter3.setBackground(Color.LIGHT_GRAY);
		pnlCenter4.setBackground(Color.LIGHT_GRAY);
		pnlCenter2.setBackground(Color.LIGHT_GRAY);
		pnlEast.setBackground(Color.LIGHT_GRAY);
		pnlEast3.setBackground(Color.LIGHT_GRAY);
		pnlEast2.setBackground(Color.LIGHT_GRAY);
		pnlEast4.setBackground(Color.LIGHT_GRAY);
		btnFindWord.setBackground(Color.LIGHT_GRAY);
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnWordCount.setBackground(Color.LIGHT_GRAY);
		txtStatus.setForeground(Color.BLUE);
		
		// Set type of font to use for labels.
		Font myFont = new Font("SansSerif",Font.BOLD,15);
		lblEnterText.setFont(myFont);
		lblNumWordsAndChars.setFont(myFont);
		lblStatus.setFont(myFont);
		lblEnterWord.setFont(myFont);
		
		// Set the overall layout of the component.
		setLayout(new BorderLayout());

		FlowLayout flo = new FlowLayout();
		pnlCenter.setLayout(flo);
		pnlCenter.add(lblEnterText);

		// Set and disables a scrollpane to the textarea.
		JScrollPane textAreaScroll = new JScrollPane(txtSearchArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnlCenter.add(textAreaScroll);
		textAreaScroll.setEnabled(false);
		txtSearchArea.setLineWrap(true);
		txtSearchArea.setWrapStyleWord(true);
		
		pnlCenter.add(lblNumWordsAndChars);
		BoxLayout box = new BoxLayout(pnlCenter3,BoxLayout.Y_AXIS);
		
		BorderLayout BordBottomLeftCenter = new BorderLayout();
		
		pnlCenter2.setLayout(BordBottomLeftCenter);
		pnlCenter3.setLayout(box);
		
		pnlCenter3.add(lblNumWords);
		pnlCenter3.add(lblNumChars);
		pnlCenter3.add(lblNumCharsNoSpaces);
		pnlCenter3.add(lblNumParas);
		pnlCenter2.add(pnlCenter3,BorderLayout.CENTER);
		pnlCenter3.setBorder(new EmptyBorder(5,0,0,0));
		
		// Add panel to the center panel.
		pnlCenter.add(pnlCenter2);		
		
		BoxLayout box3 = new BoxLayout(pnlCenter4,BoxLayout.Y_AXIS);
		pnlCenter4.setLayout(box3);
		pnlCenter4.add(txtNumWords);
		txtNumWords.setEditable(false);
		pnlCenter4.add(txtNumChars);
		txtNumChars.setEditable(false);
		pnlCenter4.add(txtNumCharsNoSpaces);
		txtNumCharsNoSpaces.setEditable(false);
		pnlCenter4.add(txtNumParas);
		txtNumParas.setEditable(false);
		pnlCenter2.add(pnlCenter4,BorderLayout.EAST);
		
		// Add the center panel to the frame.
		add(pnlCenter,BorderLayout.CENTER);		
		
		GridLayout gridEast = new GridLayout(3,1,25,0);
		pnlEast.setLayout(gridEast);
		pnlEast.setBorder(new EmptyBorder(30,0,0,0));		
		
		BoxLayout boxEast = new BoxLayout(pnlEast2, BoxLayout.Y_AXIS);
		pnlEast2.setLayout(boxEast);
		pnlEast2.add(lblEnterWord);
		pnlEast2.add(txtEnterWord);
		pnlEast2.add(lblStatus);
		pnlEast2.add(txtStatus);
		txtStatus.setEditable(false);		
		
//		BoxLayout box2 = new BoxLayout(east1, BoxLayout.X_AXIS);
		pnlEast3.add(btnFindWord);
		pnlEast3.add(btnClear);		
		
		FlowLayout flo1 = new FlowLayout();
		pnlEast4.setLayout(flo1);
		pnlEast4.add(btnWordCount);		
		
		pnlEast.add(pnlEast2);
		pnlEast.add(pnlEast3);
		pnlEast.add(pnlEast4);
		add(pnlEast,BorderLayout.EAST);	
		
		// Adds actionlisteners to the buttons. 
		btnFindWord.addActionListener(handler);
		btnWordCount.addActionListener(handler);
		btnClear.addActionListener(handler);
		
		// Make the window visible
		setVisible(true);
	}

}
