package main;

import java.awt.Color;
import java.awt.Graphics;

public class Floater implements Loader {
	
	int x, y, width, height;
	Color color;
	boolean right;
	int delayMax = 3;
	int delayCur = 0;
	int pupDelayMax = 24;
	int pupDelayCur = 0;
	
	public Floater(int x, int y, int width, int height, Color color, boolean right) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.right = right;
	}
	
	public void drawMethod(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
	}
	
	public void update(){
		
		
		
		if(delayCur < delayMax) {
			delayCur ++;
		}
		else {
			delayCur = 0;
			if(right) {
				if (x < rightBorder) {
					this.x ++;
				}
				else {
					right = false;
				}
			}
			else {
				if(x > leftBorder) {
					this.x --;
				}
				else {
					right = true;
				}
			}
		} // end of if else 
		
		//Start of falling obj timer
		
		if(pupDelayCur < pupDelayMax) {
			pupDelayCur ++;
		}
		else {
			pupDelayCur = 0;
			generatorFallingObj();
			
		} // end of if else 
		
	}
	
	 void generatorFallingObj() {
			//creates a random number of falling objects
					
			int rand = (int) (Math.random() * 10) + 1;
			
			int randR = (int) (Math.random() * 256);
			
			int randB = (int) (Math.random() * 256);
			
			int randG = (int) (Math.random() * 256);

			
//			for (int i = 0; i < rand; i++) {
				Puppy obj = new Puppy(this.x, this.y, ViewController.p.width,
						ViewController.p.height, new Color(randR,randG, randB), rand);
				
	//		}
			
		}

}
