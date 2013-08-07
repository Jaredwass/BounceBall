package game;

import objects.Ball;
import graphics.GUI;
import graphics.ObjectsThread;

public class Main {
	private static ObjectsThread objsThread;
	
	public static void init(){
		objsThread = new ObjectsThread(GUI.window.getGraphics(), GUI.offScreen, GUI.offScreen.getGraphics());
		objsThread.addObject(new Ball(5,5,.2,.2));
		
		objsThread.start();
	}
}
