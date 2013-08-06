package graphics;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUI {
	// Constants
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static JFrame window;
	
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
	}
}
