
import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	private int width;
	private int xTopLeft;
	private int yTopLeft;

	public Square(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(xTopLeft, yTopLeft, width, width);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setyTopLeft(int yTopLeft) {
		this.yTopLeft = yTopLeft;
	}

	public void setxTopLeft(int xTopLeft) {
		this.xTopLeft = xTopLeft;
	}

	public int getxTopLeft() {
		return xTopLeft;
	}

	public int getyTopLeft() {
		return yTopLeft;
	}

	// -------Get Center (x,y)-----------//
	public int getCenterX() {
		return xTopLeft + (width / 2);
	}

	public int getCenterY() {
		return yTopLeft + (width / 2);
	}

}
