package game;

import objects.Ball;
import graphics.Collision;
import graphics.GUI;
import graphics.ObjectsThread;

public class Main {
	private static ObjectsThread objsThread;
	
	public static void init(){
		// initialize game
		Collision.initGameState();
		objsThread = new ObjectsThread(GUI.canvas.getGraphics(), GUI.offScreen, GUI.offScreen.getGraphics());
		
		objsThread.addObject(new Ball(10,10,.2,.2));
		objsThread.addObject(new Ball(100,30,.2,.2));
		
		objsThread.start();
	}
}
