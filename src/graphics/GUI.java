package graphics;

import game.Main;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class GUI{
	// Constants
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	// Graphical
	public static JFrame window;
	private static BufferStrategy strat;
	
	public GUI(){
		window = new JFrame("Bounce Ball Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setResizable(false);

		// Adjust Position
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		window.setLocation(
				(toolkit.getScreenSize().width - window.getWidth()) / 2,
				(toolkit.getScreenSize().height - window.getHeight()) / 2);

		// Make visible
		window.setVisible(true);
		window.createBufferStrategy(2);
		
		// Start the game
		Main.init();
	}
}
