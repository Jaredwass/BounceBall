package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Constants;
import graphics.Collision;

public class GameObject {
	public double xPos, yPos, xVel, yVel; // movement
	
	public double oldxPos, oldyPos; // erasing in game state
	
	public BufferedImage image; // visual
	
	public GameObject(double xPos, double yPos, double xVel, double yVel){
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = xVel;
		this.yVel = yVel;
	}
	
	public void move(){
		oldxPos = xPos;
		oldyPos = yPos;
		
		// erase my old self
		Collision.drawRect(this, true, false, false, false);
		
		// get the rectangle
		boolean[][] collRect = Collision.getCollisionRect(this);
		
		// set up the variables
		boolean xColl = Collision.isColl(collRect, false);
		boolean yColl = Collision.isColl(collRect, true);
		
		/////
		if (xColl || yColl){
			for (int i = 0; i < collRect.length; ++i){
				for (int j = 0; j < collRect[0].length; ++j){
					System.out.print((collRect[i][j])?"*":"_");
				}
				System.out.println();
			}
			System.out.println("\n");
		}
		/////
		
		// Do appropriate adjustments
		if (xColl || yColl){
			if (!yColl){
				
				System.out.println("only x");
				
				xPos -= xVel;
				xVel *= Constants.DAMPER;
			}
			else if (!xColl){
				
				System.out.println("only y");
				
				yPos -= yVel;
				yVel *= Constants.DAMPER;
				xVel *= -1*Constants.DAMPER;
			}
			else{
				
				System.out.println("x and y");
				
				xPos -= xVel;
				yPos -= yVel;
				xVel *= Constants.DAMPER;
				yVel *= Constants.DAMPER;
			}
		}
		else{
			xPos += xVel;
			yPos += yVel;
			yVel += Constants.GRAVITY; // accel from gravity
		}
		
		// draw my old self back
		Collision.drawRect(this, true, false, true, false);
		
		
//		// x stuff
//		if (xPos + image.getWidth() + xVel> GUI.canvas.getWidth()){
//			xPos = GUI.canvas.getWidth() - image.getWidth();
//			xVel *= Constants.DAMPER;
//		}
//		else if (xPos + xVel< 0){
//			xPos = 0;
//			xVel *= Constants.DAMPER;
//		}
//		else{
//			xPos += xVel;
//		}
//		
//		// y stuff
//		if (yPos + image.getHeight() + yVel> GUI.canvas.getHeight()){
//			yPos = GUI.canvas.getHeight() - image.getHeight();
//			yVel *= Constants.DAMPER;
//			xVel *= -1*Constants.DAMPER;
//		}
//		else if (yPos + yVel < 0){
//			yPos = 0;
//			yVel *= Constants.DAMPER;
//		}
//		else{
//			yPos += yVel;
//		}
		
//		// Acceleration from gravity
//		if (yPos < GUI.canvas.getHeight()){
//			yVel += Constants.GRAVITY;
//		}
	}
	
	public void draw(Graphics g){
		g.drawImage(image, (int)xPos, (int)yPos, null);
	}
}
