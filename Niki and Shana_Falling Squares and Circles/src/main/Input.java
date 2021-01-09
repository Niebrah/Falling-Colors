package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public class Input implements KeyListener, MouseMotionListener, MouseInputListener {
	
	private DrawWindow dw; 
	
	public Input (DrawWindow dw) {
		this.dw = dw;
		

		dw.addKeyListener(this);
		dw.addMouseMotionListener(this);
		dw.addMouseListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	//	char code = e.getKeyChar();
		//System.out.println("the key is " + e.getKeyCode());
		// l = 37
		// up = 38
		// r = 39
		// down = 40
		
		if (e.getKeyCode() == 37) {
			ViewController.player.dashLeft = true;			
			
		}
		else if (e.getKeyCode() == 38) {
			ViewController.player.dashUp = true;
		}
		else if (e.getKeyCode() == 39) {
			ViewController.player.dashRight = true;
		}
		else if (e.getKeyCode() == 40) {
			ViewController.player.dashDown = true;
		}
		
				
	// end of the keyPressed method 	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == 37) {
			ViewController.player.dashLeft = false;			
			
		}
		else if (e.getKeyCode() == 38) {
			ViewController.player.dashUp = false;
		}
		else if (e.getKeyCode() == 39) {
			ViewController.player.dashRight = false;
		}
		else if (e.getKeyCode() == 40) {
			ViewController.player.dashDown = false;
		}



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
		//System.out.println("Click");


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

