package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;



public class Input implements KeyListener, ActionListener {
	
	private DrawWindow  dw; 
	
	public Input (DrawWindow dw) {
		this.dw = dw;
		
		dw.addKeyListener(this);
	}
	
	
	// prepare the inputs...
	public static void prepareInput (){
		
		// make a reference to the inputMap of the Game
		InputMap map = Game.drawPanel.getInputMap();
		
		// make a reference to the actionMap
		ActionMap action = Game.drawPanel.getActionMap();
		
		
		// BEGIN LEFT KEY
		// 1. -> Process the LEFT
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "LEFT_PRESSED");
		
		// 2. -> Give it an action
		action.put("LEFT_PRESSED", new AbstractAction() {

			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("The LEFT key was pressed");
					
			// end of the actionPerformed function 
			}
		// end of the Abstract Action
		});	
		// END OF LEFT KEY
		
		
		// BEGIN RIGHT KEY
		// 1. -> Process the LEFT
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "RIGHT_PRESSED");
		
		// 2. -> Give it an action
		action.put("RIGHT_PRESSED", new AbstractAction() {

			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("The RIGHT key was pressed");
			
				

			// end of the actionPerformed function 
			}
		// end of the Abstract Action
		});	
		// END OF RIGHT KEY
		
		
		// BEGIN UP KEY
		// 1. -> Process the UP
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UP_PRESSED");
		
		// 2. -> Give it an action
		action.put("UP_PRESSED", new AbstractAction() {

			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("The UP key was pressed");
				

				
			// end of the actionPerformed function 
			}
		// end of the Abstract Action
		});	
		// END OF UP KEY
		
		
		// BEGIN UP KEY
		// 1. -> Process the UP
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "UP_DOWN");
		
		// 2. -> Give it an action
		action.put("UP_DOWN", new AbstractAction() {

			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("The DOWN key was pressed");
				

				
			// end of the actionPerformed function 
			}
		// end of the Abstract Action
		});	
		// END OF UP KEY
		
		

				
	// end of the prepareInput method
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT) {
			Helper.shiftRight();
			
			Helper.generate();
		}
		
		if ( key == KeyEvent.VK_DOWN) {
			Helper.shiftDown();
			
			Helper.generate();
		}
		
		if ( key == KeyEvent.VK_UP) {
			Helper.shiftUp();
			
			Helper.generate();
		}
		
		if ( key == KeyEvent.VK_LEFT) {
			Helper.shiftLeft();
			
			Helper.generate();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
	
// end of the Input class 	
}
