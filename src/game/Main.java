package game;

import graphics.GUI;
import objects.Ball;
import objects.GameObject;

public class Main {
	Thread myThread;
	
	static GameObject myBall;
	
	public static void init(){
		myBall = new Ball(0,0,.1,.1);
		
		new gameThread().start();
	}
	
	private static class gameThread extends Thread{
		@Override
		public void run(){
			while (true){
				myBall.move();
				myBall.draw(GUI.window.getGraphics());
				
				// sleep
				try{
					Thread.sleep(5);
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
