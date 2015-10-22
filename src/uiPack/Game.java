package uiPack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Game implements ICanDraw {
	boolean isActive;
	Image image;
	
	@Override
	public boolean getIsActive() {
		return isActive;
	}

	@Override
	public void setIsActive(boolean value) {
		isActive = value;
	}

	@Override
	public void draw(Graphics g, Graphics2D g2d) {
		
	g.drawImage(image, 300, 0, 680, 680, null);
		
	}
	public Game(){
		URL url = Game.class.getResource(String.format("/imagesPack/%s", "GameOfLifeBoard.jpg"));

		if (url != null){
			image = Toolkit.getDefaultToolkit().getImage(url);
		}
	}

}
