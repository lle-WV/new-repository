import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Food {
	private int x,y; //pos
	private Color color; 
	private int mass; 
	private int rad;//
	Rectangle world = new Rectangle(-500,-500,2000,2000);
	
	public Food() {
		
		//spawn randomly on 800x600 screen
		x = (int)(Math.random()*1500);
		y = (int)(Math.random()*1500);
		
		//generate random color
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		color = new Color(red, green, blue);
	
		//mass
		mass = 5;
		
		//radius based on mass
		rad = mass;
	
		
	
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, rad*2, rad*2);
		g.setColor(color);
	}
}
