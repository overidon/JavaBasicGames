/*
 * 
 *  PAINT THE WORLD
 * 
 * 
 */

package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Main extends JFrame {

	private static final long serialVersionUID = 708170129669492531L;
	
	// i'm not sure if we will need these or not yet
	static final String gapList[] = {"0", "10", "15", "20"};
	final static int maxGap = 20; 
	
	// 1. PUBLIC STATIC AREA.. 
	static JFrame frame;
	
	// this helps us paint
	public static DrawWindow drawPanel;
	
	// let's now build a Grid Layout
	GridLayout layout 		 = new GridLayout(0, 32);
	GridLayout controlLayout = new GridLayout(2, 16);
	
	public static int panelWidth  = 256;
	public static int panelHeight = 128;	
	
	public static int frameWidth  = 1024;
	static int 		  frameHeight = 1024;	
	
	// this boolean will show if the mouse is down.. 
	public static boolean mouseDOWN = false; 
	
	public static JLabel infoA = new JLabel("mouse down: ");
	
	// store an active paintColor..... 
	public static Color paintColor    = Color.black;
	public static Color previousColor = Color.black;
	
	// store an eraseColor... 
	public static Color eraseColor = Color.white;
	

	
	// 2D array system... 
	public static RGBA[][] arr = new RGBA[16][16];
	
	
	// begin the Main constructor for Paint the world
	public Main(String name) {

		// we get access to super because we extend JFrame
		super(name);

		// let's set it to not be resizable
		setResizable(false);

		this.initializeColors();

		System.out.println("Colors info... ");


	//end of the Main constructor
	}
	
	void initializeColors() {
		
		int W = 16; 
		int H = 16;
		
		for (int r = 0; r < H; r++) {
			
			for (int c = 0; c < W; c++) {
				
				RGBA tempRGB = new RGBA(255, 255, 255, 255);
				arr[r][c] = tempRGB;
				
			}
		}
			
	// end of the initalizeColors method 	
	}
	
	// begin the addComponents method 
	public void addComponents(final Container pane) {

		// 1.A. create the main components
		final JPanel comps = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.black);
		
		comps.setBorder(border);
		// use the layout you made earlier as the gridLayout! :D 
		comps.setLayout(layout);
		
		// set the dimensions... 
		Dimension buttonSize = new Dimension(32, 32);
		comps.setPreferredSize(new Dimension( 256, 512));
		
		// this makes all the buttons... 
		for (int i = 0; i < 512; i++) {
			
			JButton button = new JButton ();
			button.setPreferredSize(buttonSize);
			
			// add this to the for loop 
			button.setEnabled(false);
			button.setContentAreaFilled(true);
			button.setBackground(Color.white);
			button.setOpaque(true);
			button.setBorder(border);
			button.setBorderPainted(true);
			
			button.addMouseListener(new MouseAdapter() {
				public void mouseEntered( MouseEvent e)  {
					// only do drag paint if the boolean of mouseDOWN is true ! :D 
					if ( mouseDOWN) {
						button.setBackground(paintColor);	
					}
				// end of the mouseEntered listener
				}
				
				
				public void mouseClicked(MouseEvent e) { 
					button.setBackground(paintColor);
					mouseDOWN = false; 
				}
				
				public void mousePressed(MouseEvent e ) {
					
					mouseDOWN = true; 
					button.setBackground(paintColor);
				}
				
				public void mouseReleased(MouseEvent e) {
					mouseDOWN = false; 	
					button.setBackground(paintColor);
				}
			});
			
			// inside the for loop 
			comps.add(button);
			
		// end of the button for loop 
		}
		

	
		// after making all the buttons in the loop 
		pane.add(comps, BorderLayout.NORTH);

		final JPanel controls = new JPanel();
		controls.setBorder(border);
		
		// BEGIN THE FOR loop for selectable colors... 
		for (int i = 0; i < Colors.colors.length; i++) {
			
			String name = "" + i;
			Color c;
			
			// this extracts the appropriate color from the list... 
			name = Colors.c_names[i];
			c    = Colors.colors[i];
					
			JButton BI = new JButton(name);
			BI.setSize(buttonSize);
			BI.setEnabled(false);
			BI.setContentAreaFilled(true);
			BI.setBackground(c);
			BI.setOpaque(true);
			BI.setBorderPainted(false);
			
			BI.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					// assign the active color
					paintColor    = c;
					// also assign the previous color (this will help with the eraser)
					previousColor = c;
					
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
					// assign the active color
					paintColor    = c;
					// also assign the previous color (this will help with the eraser)
					previousColor = c;
					
				}
				
			
			});
			
			controls.add(BI);
			
		// end of the for loop 
		}



		
		
		final JPanel tools = new JPanel();
		
		JButton eraser =  new JButton("ERASER");
		JButton pencil =  new JButton("PENCIL");
		
		eraser.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 paintColor = eraseColor;
				
			}
			
		});
			
		
		// if the pencil button is clicked 
		pencil.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				paintColor = previousColor;
			}
		});
		
		tools.add(eraser);
		tools.add(pencil);
		
		tools.setBorder(border);

		pane.add(tools,    BorderLayout.WEST);
		pane.add(controls, BorderLayout.SOUTH);
		
		drawPanel = new DrawWindow();
		drawPanel.setSize(128, 128);
		
		pane.add(drawPanel);
		
		
	// end of the addComponents method 	
	}
	
	// this function will help us show the interface
	private static void create() {
		
		frame = new Main("Paint the World with Joy!");
		
		drawPanel = new DrawWindow();
		
		System.out.println("Adding components....");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Adding components....");
		
		frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
		drawPanel.setSize(panelWidth, panelHeight);
		drawPanel.setFocusable(true);
		drawPanel.requestFocusInWindow();
		
		// make sure the frame has everything added
		((Main) frame).addComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
		
	// end of the create method
	}
	
	
	// begin the update method 
	public static void update() {
		
		// TODO -> this is where we will update characters and items..

		// DONE -> makes frames delay a few milliseconds per frame 
		try 
		{
		    // Sleep makes it so the game doesn't use too much CPU power 
			Thread.sleep(120);
		}
        catch (Exception e) 
		{
        	// the stackTrace will help you find out where the error is coming from...
        	e.printStackTrace();
        }
		
		
		// DONE -> After sleeping - Repaint the image
		frame.repaint();
		
		update();
	// end of the update method
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				create();
			}
		});

	// end of the main driver method 
	}

// end of the Main class  
}
