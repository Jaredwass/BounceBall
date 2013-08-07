package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Constants;
import graphics.GUI;

public class GameObject {
	protected double xPos, yPos, xVel, yVel; // movement
	
	protected BufferedImage image; // visual
	
	public GameObject(double xPos, double yPos, double xVel, double yVel){
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = xVel;
		this.yVel = yVel;
	}
	
	public void move(){
		// x stuff
		if (xPos + image.getWidth() + xVel> GUI.canvas.getWidth()){
			xPos = GUI.canvas.getWidth() - image.getWidth();
			xVel *= -1;
		}
		else if (xPos + xVel< 0){
			xPos = 0;
			xVel *= -1;
		}
		else{
			xPos += xVel;
		}
		
		// y stuff
		if (yPos + image.getHeight() + yVel> GUI.canvas.getHeight()){
			yPos = GUI.canvas.getHeight() - image.getHeight();
			yVel *= -1;
		}
		else if (yPos + yVel < 0){
			yPos = 0;
			yVel *= -1;
		}
		else{
			yPos += yVel;
		}
		
		// Acceleration from gravity
		if (yPos < GUI.canvas.getHeight()){
			yVel += Constants.GRAVITY;
		}
	}
	
	public void draw(Graphics g){
		g.drawImage(image, (int)xPos, (int)yPos, null);
	}
}
