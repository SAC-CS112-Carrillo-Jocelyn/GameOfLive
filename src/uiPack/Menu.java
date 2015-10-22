package uiPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Menu implements ICanDraw{
	boolean isActive; // <-- make another one of these that will tell us which image to draw
	boolean buttonActive;
	Image image1, image2, image3;
	
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
		g.setColor(Color.blue);
		g.fillRect(0, 0, 1280, 720);
		
		if (buttonActive){
			g.drawImage(image2, 500, 350, 336, 64, null);
		}
		else{
			g.drawImage(image1, 500, 350, 336, 64, null);
		}
		
	}
	
	public Menu (){
		
		URL url1 = Game.class.getResource(String.format("/imagesPack/buttons/%s", "NewGame_Normal.jpg"));
		URL url2 = Game.class.getResource(String.format("/imagesPack/buttons/%s", "NewGame_Light.jpg"));
		URL url3 = Game.class.getResource(String.format("/imagesPack/buttons/%s", "NewGame_Dark.jpg"));
		
		if (url1 != null)
			image1 = Toolkit.getDefaultToolkit().getImage(url1);
		if(url2 != null)
			image2 = Toolkit.getDefaultToolkit().getImage(url2);
		if(url3 != null)
			image3 = Toolkit.getDefaultToolkit().getImage(url3);
	}
			

}
