package videoGame;

import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Mycanvas extends Canvas implements KeyListener,MouseListener {

	Image poke = Toolkit.getDefaultToolkit().getImage("stuff/poke.png"); 
	int x = 10;
	int y = 10;
	Rectangle rect = new Rectangle(200,300,100,100);

	public Mycanvas() {
		this.setSize(600,400);
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.setFocusable(true);
		playIt("stuff/storm.wav");
	}

	public static void playIt(String filename) {
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			System.out.println("can not find file");
		}
	}

	@Override
	public void keyPressed(KeyEvent pressEvent) {
		if (x > 600) {

			x = x - 25;

		}

		// check to see if character collides with rectangle
		if (rect.contains(x,y)) {
			x = 10;
			y = 10;
			this.repaint();
			return;
		}
		if (pressEvent.getKeyCode() == 39) {
			x = x + 5;
		}
		this.repaint();
	}

	public void paint(Graphics g) {
		g.fillOval(10,10,25,25);
		g.fillRect((int)rect.getX(),(int)rect.getY(),(int)rect.getWidth(),(int)rect.getHeight());
		g.drawImage(poke,x,y,95,99,this);	
	}

	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		playIt("stuff/phaser2.wav");
		this.repaint();
	}
	public void mouseEntered(MouseEvent e) {
		System.out.print("Hey, get back in here!");
	}
	public void mouseExited(MouseEvent e) {
		System.out.print(e);
	}
	public void mousePressed(MouseEvent e) {
		System.out.print(e);
	}
	public void mouseReleased(MouseEvent e) {
		System.out.print(e);
	}
   @Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void keyReleased(KeyEvent poopypants) {
		//System.out.println(poopypants);
	}

}
