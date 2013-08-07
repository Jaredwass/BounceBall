package game;

import objects.Ball;
import graphics.GUI;
import graphics.ObjectsThread;

public class Main {
	private static ObjectsThread objsThread;
	
	public static void init(){
		objsThread = new ObjectsThread(GUI.canvas.getGraphics(), GUI.offScreen, GUI.offScreen.getGraphics());
		
		// make some balls
		for (int i = 0; i < 10; ++i){
			objsThread.addObject(new Ball(100,100,5*Math.random(),5*Math.random()));
		}
		
		objsThread.start();
	}
}
