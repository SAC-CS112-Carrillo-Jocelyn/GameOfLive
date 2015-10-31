package uiPack.controls;

import java.awt.Point;
import java.awt.Rectangle;

public interface IControl {
	boolean isReadOnly();
	Rectangle getBounds();

	void mouseOver(boolean isMouseOver, Point relativePoint);
	void click(Point relativePoint);
}