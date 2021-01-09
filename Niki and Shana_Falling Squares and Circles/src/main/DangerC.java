package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DangerC implements Loader{

	int x, y, width, height;
	Color color;
	boolean end = false;  //checks if it has reached the end of the screen
	int delayMax = 5; //this and delayCur is for animation. 
	int delayCur = 0;
	int speed;
	
	//the global storage place for these objects as a way to keep track of them all
	public static ArrayList<DangerC> circles = new ArrayList<DangerC>();
	
	public DangerC(int x, int y, int width, int height, Color color, int speed) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.speed = speed;
		this.height = height;
		
		circles.add(this);
	}
	
	public void drawMethod(Graphics g) {
		g.setColor(color);
		g.drawOval(x, y, width, height);
//		g.setColor(Color.BLACK);
//		g.drawRect(x, y, width, height);
	}
	
	
	
	public void update() {
		
		if (delayCur < delayMax) {
			delayCur++;
		} else {
			delayCur = 0;
			//how is boolean end checked out?
			
			if(y < downBorder) {
				y+=speed;
			
			}else {
				//end = true;
				circles.remove(this);
			
			}
	
		}
	} // end of update
	
	
	
}
