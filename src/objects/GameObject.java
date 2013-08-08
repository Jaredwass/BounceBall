package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Constants;
import graphics.Collision;
import graphics.GUI;

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
		
		// get the rectangle
		boolean[][] collRect = Collision.getCollisionRect(this);
		
		// set up the variables
		boolean isColl = false;
		boolean onlyX = true;
		boolean onlyY = true;
	
		// sweep horizontally for x
		for (int i = 0; i < collRect[0].length; ++i){
			int count = 0;
			for (int j = 0; j < collRect.length; ++j){
				if (collRect[i][j]){
					isColl = true;
					++count;
				}
			}
			if (0 < count && count < collRect.length){
				onlyX = false;
			}
		}
		
		// sweep veritcally for y
		for (int i = 0; i < collRect.length; ++i){
			int count = 0;
			for (int j = 0; j < collRect[0].length; ++j){
				if (collRect[i][j]){
					++count;
				}
			}
			if (0 < count && count < collRect[0].length){
				onlyY = false;
			}
		}
		
		// Do appropriate adjustments
		if (isColl){
			if (onlyX){
				xPos -= xVel;
				xVel *= Constants.DAMPER;
			}
			else if (onlyY){
				yPos -= yVel;
				yVel *= Constants.DAMPER;
				xVel *= -1*Constants.DAMPER;
			}
			else{
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
