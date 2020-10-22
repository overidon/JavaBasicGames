/*
 * PAINT THE WORLD 
 * 
 * 
 */



package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawWindow extends JPanel {


	private static final long serialVersionUID = 8242558423155622593L;

	// this needs to be paintComponent.. 
	public void paintComponent(Graphics g) {
		
		
		// 1. fill a background
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(Color.BLUE);
		g.fillOval(120, 120, 60, 60);

	// end of the paintComponent method 	
	}
	
// end of the DrawWindow class
}

