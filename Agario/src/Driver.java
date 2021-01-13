import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements MouseListener, ActionListener{
	
	//Create ArrayList for enemies
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Food> pellets = new ArrayList<Food>();
	
	public void paint(Graphics g) {
		super.paintComponent(g); // proper redrawing on the screen
		
		//g.fillOval(30, 30, 50, 50;
		
		//call each Enemy to paint themselves
		for(Enemy e: enemies) {
			e.paint(g);
		}
		
		for(Food f: pellets) {
			f.paint(g);
		}
		
	}

	
	
	public Driver(){
		JFrame frame = new JFrame("Agar.io");
		frame.setSize(800,600);
		frame.add(this);
		
		/* add 10  Enemies */
		for(int i =0 ; i < 10; i++) {
			enemies.add( new Enemy() );
		}	
		// add 200 pellets
		for(int i =0; i < 200; i++) {
			pellets.add(new Food());
		}
		Timer t = new Timer(16,this);
		t.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	
	}
	
	
	
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("here");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
