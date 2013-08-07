package graphics;

import game.Constants;

import java.awt.Graphics;

import objects.GameObject;

public class ObjectThread extends Thread{
	GameObject obj;
	Graphics g;
	
	public ObjectThread(GameObject obj, Graphics g){
		this.obj = obj;
		this.g = g;
		run();
	}
	
	@Override
	public void run(){
		while (true){
			// movement
			obj.move();
			obj.draw(g);
			
			// sleep
			try{
				Thread.sleep(Constants.SLEEP_TIME);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
