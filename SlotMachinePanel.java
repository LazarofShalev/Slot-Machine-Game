
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SlotMachinePanel extends JPanel implements ISlotMachine {

	private final static double SLOT_MACHINE_WIDTH_FRACTION = 0.8;
	private final static int RADIUS_DIVISOR = 6;
	private final static double SLOT_MACHINE_HEIGHT_DIVISOR = 1.4;

	private Square mainMachineCell = new Square(Color.black);
	private Square rightCell = new Square(Color.black);
	private Square leftCell = new Square(Color.black);
	private Square midCell = new Square(Color.black);
	
	private iDrawnShape[] shapesArray;

	private int shape1Num;
	private int shape2Num;
	private int shape3Num;

	private int flag = 0;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int mainPanelWidth = getWidth();
		int mainPanelHeight = getHeight();

		int minMainPanelLength = Math.min(mainPanelWidth, mainPanelHeight);

		double mainMachineCellSquareWidth = minMainPanelLength * SLOT_MACHINE_WIDTH_FRACTION;

		int mainPanelxCenter = mainPanelWidth / 2;
		int mainPanelyCenter = mainPanelHeight / 2;

		setSquares((int) mainMachineCellSquareWidth, mainPanelxCenter, mainPanelyCenter);

		g.setColor(Color.black);

		mainMachineCell.draw(g);
		leftCell.draw(g);
		rightCell.draw(g);
		midCell.draw(g);
		
		shapesArray = new iDrawnShape[3];

		shapesArray[0] = createShape(shape1Num, leftCell);
		shapesArray[1] = createShape(shape2Num, midCell);
		shapesArray[2] = createShape(shape3Num, rightCell);

		if (flag != 0) {
			shapesArray[0].draw(g);
			shapesArray[1].draw(g);
			shapesArray[2].draw(g);

			if (getShapeAtIndex(0).equals(getShapeAtIndex(1)) && getShapeAtIndex(1).equals(getShapeAtIndex(2))) {
				SlotMachineFrame.updateTheTextField("You Won!");
			} else {
				SlotMachineFrame.updateTheTextField("You Lost!");
			}
		}
	}
	
	private void setSquares(int mainMachineCellSquareWidth, int mainPanelxCenter, int mainPanelyCenter) {

		mainMachineCell.setWidth(mainMachineCellSquareWidth);
		mainMachineCell.setxTopLeft((int) (mainPanelxCenter - mainPanelxCenter * 0.90));
		mainMachineCell.setyTopLeft((int) (mainPanelyCenter - mainPanelyCenter * 0.9));

		leftCell.setxTopLeft(mainMachineCell.getxTopLeft() + mainMachineCell.getWidth() / 10);
		leftCell.setyTopLeft(mainMachineCell.getyTopLeft() + mainMachineCell.getWidth() / 20);
		leftCell.setWidth(mainMachineCell.getWidth() / 5);

		midCell.setxTopLeft(mainMachineCell.getxTopLeft() + leftCell.getWidth() * 2);
		midCell.setyTopLeft(mainMachineCell.getyTopLeft() + mainMachineCell.getWidth() / 20);
		midCell.setWidth(mainMachineCell.getWidth() / 5);

		rightCell.setxTopLeft(mainMachineCell.getxTopLeft() + (int) (midCell.getWidth() * 3.5));
		rightCell.setyTopLeft(mainMachineCell.getyTopLeft() + mainMachineCell.getWidth() / 20);
		rightCell.setWidth(mainMachineCell.getWidth() / 5);

	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	public Shape createShape(int index, Square chosenCell) {

		switch (index) {
		case 0:
			FilledCircle tempFilledCircle = new FilledCircle(Color.RED);
			setFilledCircle(tempFilledCircle, chosenCell);
			return tempFilledCircle;

		case 1:
			SquareWithCircles tempSquareWithCircles = new SquareWithCircles(Color.BLACK);
			setSquareWithCircles(tempSquareWithCircles, chosenCell);
			return tempSquareWithCircles;

		case 2:
			PizzaShape tempPizzaShape = new PizzaShape(Color.orange);
			setPizza(tempPizzaShape, chosenCell);
			return tempPizzaShape;

		}
		return null;
	}

	/**
	 * sets a FilledCircle size to fit the center of a cell
	 */
	private void setFilledCircle(FilledCircle tempFilledCircle, Square chosenCell) {
		int radius = chosenCell.getWidth() / 4;
		int delta = chosenCell.getWidth() / 8;
		tempFilledCircle.setRadius(radius);
		tempFilledCircle.setxCenter((chosenCell.getxTopLeft() + chosenCell.getWidth() / 2) - delta);
		tempFilledCircle.setyCenter((chosenCell.getyTopLeft() + chosenCell.getWidth() / 2) - delta);
	}

	/**
	 * sets a PizzaShape size to fit the center of a cell
	 */
	private void setPizza(PizzaShape tempPizzaShape, Square chosenCell) {
		int radius = chosenCell.getWidth() / 4;
		int delta = chosenCell.getWidth() / 8;
		tempPizzaShape.setRadius(radius);
		tempPizzaShape.setxCenter((chosenCell.getxTopLeft() + chosenCell.getWidth() / 2) - delta);
		tempPizzaShape.setyCenter((chosenCell.getyTopLeft() + chosenCell.getWidth() / 2) - delta);

	}

	/**
	 * sets a SquareWithCircles size to fit the center of a cell
	 */
	private void setSquareWithCircles(SquareWithCircles tempSquareWithCircles, Square chosenCell) {

		tempSquareWithCircles.setRadius(chosenCell.getWidth() / 8);
		tempSquareWithCircles.setWidth(chosenCell.getWidth() / 3);
		tempSquareWithCircles.setheight(chosenCell.getWidth() / 4);
		tempSquareWithCircles.setXTopLeft(chosenCell.getxTopLeft() + chosenCell.getWidth() / 3);
		tempSquareWithCircles.setYTopLeft(chosenCell.getyTopLeft() + chosenCell.getWidth() / 3);

	}

	@Override
	public void Play() {
		
		flag++;
		
		shape1Num = (int) (Math.random() * (2 - 0 + 1) + 0);
		shape2Num = (int) (Math.random() * (2 - 0 + 1) + 0);
		shape3Num = (int) (Math.random() * (2 - 0 + 1) + 0);

		repaint();
	}

	@Override
	public Shape getShapeAtIndex(int index) {
		if (0 <= index && index <= 2) {
			return (Shape) shapesArray[index];
		}
		return null;
	}
}
