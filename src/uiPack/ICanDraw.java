package uiPack;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface ICanDraw {
	boolean getIsActive();
	void setIsActive(boolean value);

	void draw(Graphics g, Graphics2D g2d);
}