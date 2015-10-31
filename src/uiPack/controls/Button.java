package uiPack.controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import utilsPack.Resources;

@SuppressWarnings("unused")

public class Button extends ControlBase {
	private Image normalImage;
	private Image lightImage;
	private Image darkImage;

	public Button(String imageName, int x, int y, int width, int height){
		super(new Rectangle(x, y, width, height));

		normalImage = Resources.loadImageOrFallback("buttons", String.format("%s_Normal.jpg", imageName));
		lightImage = Resources.loadImageOrFallback("buttons", String.format("%s_Light.jpg", imageName));
		darkImage = Resources.loadImageOrFallback("buttons", String.format("%s_Dark.jpg", imageName));
	}

	@Override
	public void click(Point relativePoint) {
		// TODO: Execute the logic or fire an event?
	}

	@Override
	public void draw(Graphics g, Graphics2D g2d) {
		g.drawImage(isMouseOver ? lightImage : normalImage, bounds.x, bounds.y, bounds.width, bounds.height, null);
	}
}