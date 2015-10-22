package uiPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PlayerToken implements ICanDraw {

	@Override
	public boolean getIsActive() {
		return true;
	}

	@Override
	public void setIsActive(boolean value) {
	}

	@Override
	public void draw(Graphics g, Graphics2D g2d) {
		g.setColor(Color.red);
		g.drawOval(0, 0, 50, 50);
	}

}