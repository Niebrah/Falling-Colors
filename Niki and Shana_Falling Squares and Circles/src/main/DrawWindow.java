package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawWindow extends JPanel implements Loader {
	
	private static final long serialVersionUID = 8242558423155622593L;

	public void paintComponent(Graphics g) {
		
		//sets the original board                                   
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//the thing producing falling objects
		ViewController.p.drawMethod(g);
		//the player-controlled object gets drawn
		ViewController.player.drawMethod(g);
	
		//falling squares gets drawn	
		for (int z = 0; z < Puppy.puppies.size(); z++ ) {
			
			boolean position2 = Puppy.puppies.get(z).end;
			if (!position2) Puppy.puppies.get(z).drawMethod(g);
			
		}
		

		//falling circles gets drawn	
		for (int z = 0; z < DangerC.circles.size(); z++ ) {
			
			boolean position2 = DangerC.circles.get(z).end;
			if (!position2) DangerC.circles.get(z).drawMethod(g);
			
		}
		
		
		
		}
	
	
}
