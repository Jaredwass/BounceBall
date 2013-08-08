package graphics;

import game.Constants;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import objects.GameObject;

public class ObjectsThread extends Thread{
	public ArrayList<GameObject> objs;
	
	Graphics g;
	Image offScreen;
	Graphics offg;
	
	public ObjectsThread(Graphics g, Image offScreen, Graphics offg){
		this.objs = new ArrayList<GameObject>();
		this.g = g;
		this.offScreen = offScreen;
		this.offg = offg;
	}
	
	@Override
	public void run(){
		while (true){
			// Erase old screen
			offg.clearRect(0, 0, GUI.window.getWidth(), GUI.window.getHeight());
			
			// Move and draw all the objects
			for (GameObject obj:objs){
				obj.move();
				obj.draw(offg);
			}
			
			// Update the game state
			for (GameObject obj:objs){
				int[] numsOld = new int[]{(int) obj.oldxPos, (int) obj.oldyPos,
				                (int) (obj.oldxPos + obj.image.getWidth()), 
				                (int) (obj.oldyPos + obj.image.getHeight())};
				int[] numsNew = new int[]{(int) obj.xPos, (int) obj.yPos,
				                (int) (obj.xPos + obj.image.getWidth()), 
				                (int) (obj.yPos + obj.image.getHeight())};

				Collision.drawRect(numsOld, numsNew, true);
			}
			
			// Put new image on screen
			g.drawImage(offScreen, 0,0,null);
			
			// Sleep
			try{
				sleep(Constants.SLEEP_TIME);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
