/*
 * PROJECT: CasualTetris
 * FILE: DrawWindow
 * 
 */


package main;

// imports for color etc.
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

// import the JPanel 
import javax.swing.JPanel;

// extend (inherit) the DrawWindow so it can be used for our game! 
public class DrawWindow extends JPanel{
	
	private static final long serialVersionUID = 8242558423155622593L;

	// 1. The paintComponent actually draws our rectangles etc. to the JPanel 
	public void paintComponent(Graphics g) {
		
		//System.out.println("***The PAINT is working ***");
		// 2.  fill a black background... 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// 3. Draw the Pieces in the board
		drawBoard(g);
	

		
		
	// end of the paintComponent Method	
	}
	
	
	void drawBoard(Graphics g) {
		
		int r = Game.board.length;
		int c = Game.board[0].length;
		
		for (int row = 0; row < r; row++ ) {
			
			for (int col = 0; col < c; col++) {
				
				int val = Game.board[row][col];
				
				if ( val != 0) {
					g.setColor(Color.white);
					g.setFont(new Font("Arial", Font.PLAIN, 32)); 
					
					g.drawString("" + val, (col * 64) + 32, row * 64  + 44);
				}
				
				// draw the grid!
				g.setColor(Color.white);
				g.drawRect(col * 64, row * 64, 64, 64);
				
			// end of the inner for loop
			}
			
		// end of the outer for loop	
		}
		
		
	// end of the drawGrid method
	}
	
	

	
// end of the DrawWindow class 
}
