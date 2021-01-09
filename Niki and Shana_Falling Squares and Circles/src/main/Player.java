package main;

import java.awt.Color;
import java.awt.Graphics;

public class Player implements Loader {
	
	int x, y, width, height;
	Color color;
	
	 boolean dashLeft, dashRight;
	 boolean dashUp, dashDown;
	
	public Player(int x, int y, int width, int height, Color color) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dashLeft = false;
		this.dashRight = false;
		
		this.dashDown = false;
		this.dashUp = false;
	}
	
	public void drawMethod(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
//		g.setColor(Color.BLACK);
//		g.drawRect(x, y, width, height);
	}
	
	public void update() {
		if (dashRight && x < rightBorder) {
			x++;
		}
		if (dashLeft && x > leftBorder) {
			x--;
		}
		if (dashUp && y > upBorder) {
			y--;
		}
		if (dashDown && y < downBorder) {
			y++;
		}
		
	}
	
	
	
	
}
