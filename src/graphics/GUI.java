package graphics;

import game.Main;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUI{
	// Constants
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	// Graphical
	public static JFrame window;
	public static Canvas canvas;
	public static Image offScreen;
	
	public GUI(){
		window = new JFrame("Bounce Ball Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setResizable(false);
		
		canvas = new Canvas();
		window.add(canvas);

		// Adjust Position
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		window.setLocation(
				(toolkit.getScreenSize().width - window.getWidth()) / 2,
				(toolkit.getScreenSize().height - window.getHeight()) / 2);

		// Make visible
		window.setVisible(true);
		
		// Double buffering
		offScreen = GUI.window.createImage(canvas.getWidth(), canvas.getHeight());
		
		// Start the game
		Main.init();
	}
}
