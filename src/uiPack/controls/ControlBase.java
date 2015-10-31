package uiPack.controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import uiPack.ControlInputHandler;
import uiPack.ICanDraw;

public abstract class ControlBase implements IControl, ICanDraw {
	protected Rectangle bounds;
	protected boolean isActive;
	protected boolean isReadOnly;
	protected boolean isMouseOver;

	@Override
	public boolean getIsActive() {
		return isActive;
	}

	@Override
	public void setIsActive(boolean value) {
		isActive = value;

		// The control can register itself. Makes it easier to use them. Just slap them on a
		// page and tie their IsActive into the page's IsActive.
		if (value){
			ControlInputHandler.register(this);
		}
		else{
			ControlInputHandler.unregister(this);
		}
	}

	@Override
	public boolean isReadOnly() {
		return isReadOnly;
	}

	protected void setReadOnly(boolean value){
		isReadOnly = value;
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	protected ControlBase(Rectangle bounds){
		this.bounds = bounds;
	}

	@Override
	public void mouseOver(boolean isMouseOver, Point relativePoint) {
		this.isMouseOver = isMouseOver;
	}

	@Override
	public abstract void click(Point relativePoint);

	@Override
	public abstract void draw(Graphics g, Graphics2D g2d);
}