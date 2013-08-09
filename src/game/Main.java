package game;

import objects.Ball;
import objects.GameObject;
import graphics.Collision;
import graphics.GUI;
import graphics.ObjectsThread;

public class Main {
	private static ObjectsThread objsThread;
	
	public static void init(){
		// initialize game
		Collision.initGameState();
		objsThread = new ObjectsThread(GUI.canvas.getGraphics(), GUI.offScreen, GUI.offScreen.getGraphics());
		
		objsThread.objs.add(new Ball(10,10,1,.2));
		objsThread.objs.add(new Ball(60,10,-1,.2));
		
		for (GameObject obj:objsThread.objs){
			Collision.drawRect(obj, false, true, false, true);
		}
		
		objsThread.start();
	}
}
