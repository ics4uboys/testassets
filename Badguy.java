package videoGame;

public class Badguy {

	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	
	public Badguy() {
	}
	public Badguy(int x, int y, int w, int h) {
		xCoord = x;
		yCoord = y;
		width = w;
		height = h;
	}
	
	public int getXcoord() {
		return xCoord;
	}
	
	public int getYcoord() {
		return yCoord;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	

}
