package videoGame;

import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.InputStream;
import java.util.Random;
import java.io.FileInputStream;
import java.io.IOException;

public class Mycanvas extends Canvas implements KeyListener,MouseListener {

	// MHOEL - create image - default looking right
	String imgname = "stuff/right.png";
	
	Image poke = Toolkit.getDefaultToolkit().getImage(imgname); 
	int x = 10;
	int y = 10;
	//Rectangle rect = new Rectangle(200,300,100,100);
	
	// Make an empty array for badguys
	Badguy badguys[] = new Badguy[5];

	public Mycanvas() {
		this.setSize(600,400);
		
		// MHOEL - set background to be white
		this.setBackground(Color.white);
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.setFocusable(true);
		
		// MHOEL - fill an array of stationary bad guys
		Random rand = new Random();
		for (int i = 0; i<5; i++) {
			badguys[i] = new Badguy(rand.nextInt(600), rand.nextInt(400), 50, 50);
		}
		
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
		
		if (this.getContains()) {
			x = 10;
			y = 10;
			this.repaint();
			return;
		}
		
		if (pressEvent.getKeyCode() == 39) {
			// MHOEL - if image is right, change to runright and vice versa
			if (imgname == "stuff/right.png") {
				imgname = "stuff/runright.png";
			} else {
				imgname = "stuff/right.png";
			}
			poke = Toolkit.getDefaultToolkit().getImage(imgname);
			x = x + 5;
		}
		this.repaint();
	}
	
	public boolean getContains(){
		boolean containsHero = false;
		Rectangle bgRect = new Rectangle();
		for (Badguy bg: badguys) {
			bgRect.x = bg.getXcoord();
			bgRect.y = bg.getYcoord();
			bgRect.width = bg.getWidth();
			bgRect.height = bg.getHeight();
			if (bgRect.contains(x,y)) {
				containsHero = true;
			}
		}
		return containsHero;
	}

	public void paint(Graphics g) {
		
		// MHOEL - draw stationary badguys
		for (Badguy bg: badguys) {
			g.fillRect(bg.getXcoord(), bg.getYcoord(), bg.getWidth(), bg.getHeight());
		}
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
