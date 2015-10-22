package uiPack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Form {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 10, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PaintPanel panel = new PaintPanel();
		Game value = new Game();
		MenuController.menu.setIsActive(true);
		
		InputHandler handler = new InputHandler();
		panel.addMouseListener(handler);
		panel.addMouseMotionListener(handler);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		//panel.addDrawable(new PlayerToken());
		panel.addDrawable(MenuController.menu);
		panel.addDrawable(value);
	}

}
