


import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements iDrawnShape {

	private Color color;

	public Shape(Color color) {
		this.color = color;
	}

	public boolean equals(Object objectToCheck) {
		if (this.getClass().equals(objectToCheck.getClass())) {
			return true;
		}
		return false;
	}

	public abstract int getCenterX();

	public abstract int getCenterY();

	public abstract void draw(Graphics g);

}
