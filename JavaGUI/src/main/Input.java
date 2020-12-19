public class Input implements KeyListener, MouseMotionListener, MouseInputListener {
	
	private DrawWindow  dw; 
	
	public Input (DrawWindow dw) {
		this.dw = dw;
		

		dw.addKeyListener(this);
		dw.addMouseMotionListener(this);
		dw.addMouseListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		char code = e.getKeyChar();


				
	// end of the keyPressed method 	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		char code = e.getKeyChar();



	// end of the keyReleased method
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {



	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click");


	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
