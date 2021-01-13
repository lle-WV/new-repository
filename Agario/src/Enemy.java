import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	private int x,y; //pos
	private Color color; 
	private int vx, vy;
	private int mass; 
	private int rad;//
	Rectangle world = new Rectangle(-500,-500,2000,2000);
	
	public Enemy() {
		// have enemy move randomly with vx and vy
		//non zero value between 3 and -3
		while(vx == 0) {	
			vx = (int)(Math.random()*(3-(-3)+1)-3);
		}
		while(vy == 0) {
			vy = (int)(Math.random()*(3-(-3)+1)-3);
		}
		//spawn randomly on 800x600 screen
		x = (int)(Math.random()*1500);
		y = (int)(Math.random()*1500);
		
		//generate random color
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		color = new Color(red, green, blue);
	
		//mass
		mass = (int)(Math.random()*25-5);
		
		//radius based on mass
		rad = mass*2;
	
		
	
	}
	

		
	
	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public Color getColor() {
		return color;
	}




	public void setColor(Color color) {
		this.color = color;
	}




	public int getVx() {
		return vx;
	}




	public void setVx(int vx) {
		this.vx = vx;
	}




	public int getVy() {
		return vy;
	}




	public void setVy(int vy) {
		this.vy = vy;
	}




	public int getMass() {
		return mass;
	}




	public void setMass(int mass) {
		this.mass = mass;
	}




	public int getRad() {
		return rad;
	}




	public void setRad(int rad) {
		this.rad = rad;
	}




	public Rectangle getWorld() {
		return world;
	}




	public void setWorld(Rectangle world) {
		this.world = world;
	}




	private int minX() {
		// TODO Auto-generated method stub
		return (int) world.getMinX();
	}
	private int maxX() {
		return (int) world.getMaxX();
	}
	private int minY() {
		return (int) world.getMinY();
		
	}
	private int maxY() {
		return (int) world.getMaxY();
	}



	public void paint(Graphics g) {
		update();
		g.fillOval(x, y, rad*2, rad*2);
		g.setColor(color);
		if(rad >= 40){
			vx-=1;
			vy-=1;
		}
		if(x <= minX()) {
			vx*=-1;
		}
		if(x >= maxX()) {
			vx*=-1;
		}
		if(y <= minY()) {
			vy*=-1;
		}
		if(y >= maxY()) {
			vy*=-1;
		}
		
		//inverse relationship of rad to slower velo
		while(rad > 15) {
			vx-=rad-15;
			vy-=rad-15;
		}
		
	}

	//collision
	public boolean collide(Enemy en2, Enemy en1) {
		double d = Math.sqrt(Math.pow((en2.getY()),2)+(en2.getX()-en1.getX()));
		int radSum = en2.getRad() + en1.getRad();
		if(d < radSum) {
			return true;
		}
		return false;
	}
	
	
	
	public void update() {
		x+=vx;
		y+=vy;
	}
	
}

