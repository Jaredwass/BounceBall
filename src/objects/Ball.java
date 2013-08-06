package objects;

import java.io.File;

import javax.imageio.ImageIO;

public class Ball extends GameObject{
	
	public Ball(double xPos, double yPos, double xVel, double yVel){
		super(xPos, yPos, xVel, yVel);
		
		// image
		try{
			image = ImageIO.read(new File("res/ball.png"));
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
