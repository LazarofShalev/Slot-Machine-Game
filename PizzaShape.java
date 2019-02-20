


import java.awt.Color;
import java.awt.Graphics;

public class PizzaShape extends Shape {

	private int xCenter;
	private int yCenter;
	private int radius;

	public PizzaShape(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.yellow);
		g.fillArc(xCenter, yCenter, radius, radius, 0, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 40, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 80, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 120, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 160, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 200, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 240, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 280, 30);
		g.fillArc(xCenter, yCenter, radius, radius, 320, 30);

	}

	@Override
	public int getCenterX() {
		return xCenter;
	}

	@Override
	public int getCenterY() {
		return yCenter;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setxCenter(int xCenter) {
		this.xCenter = xCenter;
	}

	public void setyCenter(int yCenter) {
		this.yCenter = yCenter;
	}
}