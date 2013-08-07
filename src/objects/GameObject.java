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
		if (xPos + image.getWidth()> GUI.window.getWidth()){
			xPos = GUI.window.getWidth() - image.getWidth();
			xVel *= -1;
		}
		else if (xPos< 0){
			xPos = 0;
			xVel *= -1;
		}
		else{
			xPos += xVel;
		}
		
		// y stuff
		if (yPos + image.getHeight()> GUI.window.getHeight()){
			yPos = GUI.window.getHeight() - image.getHeight();
			yVel *= -1;
		}
		else if (yPos< 0){
			yPos = 0;
			yVel *= -1;
		}
		else{
			yPos += yVel;
		}
		
		// Acceleration from gravity
		if (yPos < GUI.window.getHeight()){
			yVel += Constants.GRAVITY;
		}
	}
	
	public void draw(Graphics g){
		g.drawImage(image, (int)xPos, (int)yPos, null);
	}
}
