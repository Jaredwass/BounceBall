package game;

import java.util.ArrayList;

import objects.Ball;

import graphics.GUI;
import graphics.ObjectThread;

public class Main {
	static ArrayList<ObjectThread> objectThreads;
	
	public static void init(){
		objectThreads = new ArrayList<ObjectThread>();
		objectThreads.add(new ObjectThread(new Ball(0,0,.2,0), GUI.window.getGraphics()));
	}
}
