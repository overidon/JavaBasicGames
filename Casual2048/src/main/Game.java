/*
 * Project: Casual 2048
 * 
 * Student -> Sachin
 * 
 */

package main;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Game {
	
	static JFrame frame;
	
	// this helps us paint
	public static DrawWindow drawPanel;

	// we will set the width and height of the screen
	public static int windowWidth = 500;
	public static int windowHeight = 596;	
	

	public static int [][] board = new int[4][4];
	
	
	public static void main(String[] args) {
		
		// prep the board before calling the GUI
		prepBoard();
		
		// 1. Prepare your Graphical User Interface
		new Game().prepareGui();
		
	// end of the main driver method
	}
	
	
	static void prepBoard() {
		
		// randomize the row and column
		int row = (int)(Math.random() * 4);
		int col = (int)(Math.random() * 4);
		
		// place a 2 in the correct spot
		board[row][col] = 2;
		
		boolean safe = false;
		
		System.out.println("The first PIECE row is: " + row);
		System.out.println("The first PIECE col is: " + col);
		
		// spawn 2nd starter piece
		while ( !safe) {
			
			int row2 = (int) (Math.random() * 4);
			int col2 = (int) (Math.random() * 4);
			
			
			System.out.println("The value at the row of : " + row2 + " and the col of : " + col2 + " is: " + board[row2][col2]);
			
			
			if ( board[row2][col2] == 0) {
				
			
				
				System.out.println("Valid 2nd piece...");
				
			
				board[row2][col2] = 2;
				
				safe = true;
				
			} else {
				System.out.println("INVALID 2nd piece...");
			}
			
			
		}
		
		
	// end of the prepBoard method
	}
	
	// begin the prepareGui method
	private void prepareGui()  {
		
		// 1. Set the title of the game for the window
		frame = new JFrame("Casual 2048");
		
		// 2. Make it so when you click the X the window closes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// 3. Complete the initialization of the DrawWindow so we can use it later
		drawPanel = new DrawWindow();
		
		new Input(drawPanel);
		
		// 4. Make it so the panel is centered in the layout
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		// 5. Make it so the frame cannot be resized
		frame.setResizable(false);
		
		// 6. Make it so the drawPanel can be focused.
		drawPanel.setFocusable(true);
		
		// 7. Make the drawPanel focused in the frame.
		drawPanel.requestFocusInWindow();

		// 8. Use the integers we made earlier to set the width and height of our game!
		frame.setSize(windowWidth, windowHeight);
		
		// 9. Let the operating system assist in where to put the window.
		frame.setLocationByPlatform(true);
		
		// 10. Make it so the frame is visible!
		frame.setVisible(true);
		
		// Connect the input to the Game -> Keyboard - Mouse etc
		//Input.prepareInput();
		
		update();
		
	// end of the prepareGui method 
	}
	
	// begin the update method
	public static void update()  {
		//IMPORTANT !!!
		while (true) {
			
			// 1. We will update our lists and objects here! 
			
			// IMPORTANT sleep method.. 
			try 
			{
			    // Sleep makes it so the game doesn't use too much CPU power 
				Thread.sleep(16);
			}
	        catch (Exception e)
	        {
	        	e.printStackTrace();
	        }
			
			
			// This connects to our drawWindow
			frame.repaint();
		// end of the while true loop
		}
	// end of the update method...
	}

// end of the Game class 
}
