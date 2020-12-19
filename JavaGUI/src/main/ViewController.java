/*
 *      PROJECT: JavaGUI
 *      FILE   : ViewController.java
 * DESCRIPTION : Primary View Controller and holds the 
 * 				 main driver method! 
 * 
 */


package main;

import java.awt.BorderLayout;
import java.io.IOException;

// javax imports 
import javax.swing.JFrame;

public class ViewController {

	// 1. PUBLIC STATIC AREA.. 
	static JFrame frame;
	
	// 2. The drawPanel helps us paint
	public static DrawWindow drawPanel;
	
	// 3. Store width and height of program
	public static int windowWidth  = 800;
	public static int windowHeight = 600;	
	
	// begin the main driver method 
	public static void main(String[] args) {
		
		System.out.println("... running DrawIO ...");
		
		
		// IMPORTANT -> Create the ViewController() instance 
		//              with the prepareGui method
		new ViewController().prepareGui();

	// end of the main driver method 
	}
	
	// begin update method 
	public static void update() throws IOException {
		//IMPORTANT !!!
		while (true) {

			// IMPORTANT sleep method.. 
			try {Thread.sleep(6);}
			
	        catch (Exception e)
			
	        {e.printStackTrace();}
			
			//After sleeping - Repaint the image
			frame.repaint();
		}
	// end of the update method 
	}
	
	
	// begin the prepareGui method 
	private void prepareGui() {
		
		// 1. We need a frame to hold the Graphical User Interface
		frame = new JFrame("Starter Project");
		
		// 2. Make it so the Red X button closes the program! 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 3. Now create a new instance of the DrawWindow class
		//    NOTE: We are using the uninitialized drawPanel variable
		drawPanel = new DrawWindow();
		
		// TODO -> 3.B Integrate input system
		
		// 4. Make a Layout that can hold the drawPanel easily
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		// 5. For right now we will make the program NOT resize-able
		frame.setResizable(false);
		
		// 6. Also the program will start focused so we should 
		//    be able to use it right away
		drawPanel.setFocusable(true);
		drawPanel.requestFocusInWindow();
		
		// 7. Set the frame size to use the variables from earlier
		frame.setSize(windowWidth, windowHeight);
		
		// 8. Allow the platform to set its location automatically
		frame.setLocationByPlatform(true);
		
		// 9. Make sure the frame is visible... 
		frame.setVisible(true);
		
		// 10  -> TODO Connect Input 
		
		// 11. Update the system. 
		try {update();} catch (IOException e){e.printStackTrace();} 
		
		
	// end of the prepareGui method 
	}

	
// end of the ViewController class 
}
