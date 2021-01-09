package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

// javax imports 
import javax.swing.JFrame;

public class ViewController implements Loader{

	//TODO make falling object that reduce side; x, radius method
	
	// 1. PUBLIC STATIC AREA.. 
	static JFrame frame;
	
	// 2. The drawPanel helps us paint
	public static DrawWindow drawPanel;
	
	public static Floater p = new Floater(256, 0, 16, 16, Color.LIGHT_GRAY, true);
	public static Player player = new Player(256, windowHeight - headerHeight, 2, 2, Color.RED);
	
	// begin the main driver method 
	public static void main(String[] args) {
		
		// IMPORTANT -> Create the ViewController() instance 
		//              with the prepareGui method
		new ViewController().prepareGui();

	// end of the main driver method 
	}
	

	public static boolean checkCol(Puppy a, Player b) {
		
		//determines if eating occurs
		
		int xA = a.x;
		int yA = a.y;
		int wA = a.width;
		int hA = a.height;
		
		int xB = b.x;
		int yB = b.y;
		int wB = b.width;
		int hB = b.height;
		
		//axises - |
		boolean checkX = ( ((xA + wA) > xB) && (xA < (xB + wB)) );
		boolean checkY = ( ((yA + hA) > yB) && (yA < (yB + hB)) );
		
		//need to consider corners
		return (checkX && checkY);
	}
	
	// begin update method 
	public static void update() throws IOException {
		//IMPORTANT !!!
		while (true) {
			
			for (int z = 0; z < Puppy.puppies.size(); z++ ) {
				
				Puppy.puppies.get(z).update();
				
			}
			
			for (int j = 0; j < Puppy.puppies.size(); j++ ) {
				
				Puppy dog = Puppy.puppies.get(j);
				
				if (checkCol(dog, player)) {
					int randX = (int) (Math.random() * windowWidth);
					p.x = randX;
					Puppy.puppies.remove(j);
					player.width++;
					player.height++;
					//might get concurrent modification issue
				}
				
			}
			
			//for circles
			
			for (int z = 0; z < DangerC.circles.size(); z++ ) {
				
				DangerC.circles.get(z).update();
				
			}
			
			for (int j = 0; j < DangerC.circles.size(); j++ ) {
				
				DangerC c = DangerC.circles.get(j);
				
				if (checkColD(c, player)) {
					int randX = (int) (Math.random() * windowWidth);
					p.x = randX;
					DangerC.circles.remove(j);
					player.width--;
					player.height--;
					//might get concurrent modification issue
				}
				
			}
		
			
			player.update();
			p.update();

			// IMPORTANT sleep method.. 
			try {
				Thread.sleep(6);
				//lower thread sleep numbers are 1) faster 2) eat up more battery
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			//After sleeping - Repaint the image
			frame.repaint();
		}
	// end of the update method 
	}
	

	public static boolean checkCorners(int PX, int PY, DangerC c) {
		
		int radiusW = c.width / 2;
		int radiusH = c.height / 2;
		int cirCenterX = c.x + radiusW;
		int cirCenterY = c.y + radiusH;
		
		int disX = Math.abs(cirCenterX + - PX);
		int disY = Math.abs(cirCenterY - PY);
		// PX, PY is the corner of the Player
		
		return disX <= radiusW && disY <=radiusH;
	}
	
	
	public static boolean checkColD(DangerC c, Player b) {
		
		boolean result = false;
		
		int radiusW = c.width / 2;
		int radiusH = c.height / 2;
		
		int xB = b.x;
		int yB = b.y;
		int wB = b.width;
		int hB = b.height;
		
		int rectEast = xB + wB;
		int rectSouth = yB + hB;
		int cirCenterX = c.x + radiusW;
		int cirCenterY = c.y + radiusH;
		
		int TRX = xB + wB;
		int TRY = yB;
		int TLX = xB;
		int TLY = yB;
		
		int BRX = TRX;
		int BRY = TRY;
		int BLX = TLX;
		int BLY = TLY;
		
		if (checkCorners(TRX, TRY, c)) return true;
		
		if (checkCorners(TLX, TLY, c)) return true;
		
		if (checkCorners(BRX, BRY, c)) return true;
		
		if (checkCorners(BLX, BLY, c)) return true;
		
		
		//east boundary: x position - radius is
		//being compared against the x position
		//of the rect
		
		boolean eastCheck = ( (cirCenterX - radiusW) < rectEast);

		//west boundary: 

		boolean westCheck = ( (cirCenterX - radiusW) > xB);

		//north boundary: 
		
		boolean northCheck = (cirCenterY + radiusH) > yB;
		
		//south boundary: 
		
		boolean southCheck = (cirCenterY - radiusH) < rectSouth;
		
		return result;
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
		new Input(drawPanel);
		
		// 11. Update the system. 
		try {update();} catch (IOException e){e.printStackTrace();} 
		
		
	// end of the prepareGui method 
	}

	
// end of the ViewController class 
}
