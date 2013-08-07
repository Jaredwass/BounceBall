package graphics;

import game.Constants;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import objects.GameObject;

public class ObjectsThread extends Thread{
	private ArrayList<GameObject> objs;
	
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
	
	public void addObject(GameObject obj){
		objs.add(obj);
	}
}
