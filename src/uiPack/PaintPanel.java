package uiPack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1276408633985928729L;

	private Timer repaintTimer;
	private List<ICanDraw> drawables = new ArrayList<ICanDraw>();

	public PaintPanel(){
		repaintTimer = new Timer(16, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		repaintTimer.start();
	}

	public void addDrawable(ICanDraw drawable){
		drawables.add(drawable);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		// It's actually a Graphics2D, because it's 2D, and we need some special properties on this thing.
		Graphics2D g2d = (Graphics2D)g;

		// Make it look smooth.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw the active drawables.
		for (ICanDraw drawable : drawables){
			if (drawable.getIsActive()){
				drawable.draw(g, g2d);
			}
		}
	}
}