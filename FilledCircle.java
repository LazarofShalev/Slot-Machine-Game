
import java.awt.Color;
import java.awt.Graphics;

public class FilledCircle extends Shape {

	private int radius;
	private int xCenter;
	private int yCenter;

	public FilledCircle(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(xCenter, yCenter, radius, radius);

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

	@Override
	public int getCenterX() {
		return xCenter;
	}

	@Override
	public int getCenterY() {
		return yCenter;
	}

}
