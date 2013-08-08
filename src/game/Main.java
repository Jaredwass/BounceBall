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
		
		objsThread.objs.add(new Ball(10,10,.2,.2));
		objsThread.objs.add(new Ball(100,30,.2,.2));
		
		for (GameObject obj:objsThread.objs){
			int[] numsOld = new int[]{(int) obj.oldxPos, (int) obj.oldyPos,
						              (int) (obj.oldxPos + obj.image.getWidth()), 
						              (int) (obj.oldyPos + obj.image.getHeight())};
			int[] numsNew = new int[]{(int) obj.xPos, (int) obj.yPos,
						              (int) (obj.xPos + obj.image.getWidth()), 
						              (int) (obj.yPos + obj.image.getHeight())};

			Collision.drawRect(numsOld, numsNew, false);
		}
		
		objsThread.start();
	}
}
