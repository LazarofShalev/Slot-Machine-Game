

import java.awt.Color;
import java.awt.Graphics;

public class SquareWithCircles extends Shape {

	private int radius;
	private int xTopLeft;
	private int yTopLeft;
	private int width;
	private int height;

	public SquareWithCircles(Color color) {
		super(color);
	}

	@Override
	public int getCenterX() {
		return width / 2;
	}

	@Override
	public int getCenterY() {
		return width / 2;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(xTopLeft, yTopLeft, width, height);
		g.fillOval(xTopLeft - width / 6, yTopLeft + height / 3, radius, radius);
		g.fillOval(xTopLeft + width - (width / 6), yTopLeft + height / 3, radius, radius);
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setheight(int height) {
		this.height = height;
	}

	public void setXTopLeft(int xTopLeft) {
		this.xTopLeft = xTopLeft;
	}

	public void setYTopLeft(int yTopLeft) {
		this.yTopLeft = yTopLeft;
	}

}
