import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;



public class DrawingPanel extends JPanel {
	private Color color;
	ArrayList<MyShape> shapesList = new ArrayList<MyShape>();
	int alterindex = 0;
	String command;
	
	public void setcommand(String cmd) {
		command = cmd;
	}
	public int rint(int max) {
		// Deze functie kiest een random integer tussen 0 en max
		Random rand = new Random();
		return rand.nextInt(max);
	}
	
	public void addmouseShape(Point start, Point end) {
		MyShape shape = null;
		switch(command) {
			case "Rectangle":
	            shape = new MyRectangle(start.x, start.y, end.x, end.y);
	            break;
			case "Line":
				shape = new MyLine(start.x, start.y, end.x, end.y);
				break;
			case "Ellipse":
				shape = new MyEllipse(start.x, start.y, end.x, end.y);
				break;
	        default:
	            break;
		}
		shapesList.add(shape);
		repaint();
	}
	
	public void addLine(Point start, Point end) {
		MyShape line = new MyLine(start.x, start.y, end.x, end.y);
		shapesList.add(line);
		repaint();
	}

    public void addShape(int numshape) {
        int rx, ry;
        Random rand = new Random();
        MyShape shape = null;
        rx = rint(200);
        ry = rint(200);

        switch (numshape) {
            case 0:
                shape = new MyRectangle(rx, ry, rx+30, ry+30);
                break;
            case 1:
                rx = rint(200);
                ry = rint(200);
                int rx1 = (int) Math.floor(rx+Math.cos(rint(360))*30);
                int ry2 = (int) Math.floor(ry+Math.sin(rint(360))*30);
                shape = new MyLine(rx,ry,rx1,ry2);
                break;
            case 2:
                shape = new MyEllipse(rx,ry,rx+30,ry+30);
                break;
            default:
                break;
        }
        shapesList.add(shape);
        repaint();
    }

	public void addRandomShape() {
		int rx, ry;
		Random rand = new Random();
		//int randint = rand.nextInt(3);
		MyShape shape = null;
		
		
		switch (rint(3)) {
		case 0:
			rx = rint(200);
			ry = rint(200);
			shape = new MyEllipse(rx,ry,rx+30,ry+30);
			break;
		case 1:
			rx = rint(200);
			ry = rint(200);
			int rx1 = (int) Math.floor(rx+Math.cos(rint(360))*30);
			int ry2 = (int) Math.floor(ry+Math.sin(rint(360))*30);
			shape = new MyLine(rx,ry,rx1,ry2);
			break;
		case 2:
			rx = rint(200);
			ry = rint(200);
			shape = new MyRectangle(rx,ry,rx+30,ry+30);
			break;
		}
		shapesList.add(shape);
		repaint();
		
		

	}
	
	public void alterNextShape() {
		if (alterindex >= shapesList.size()) {
			alterindex = 0;
		}
		MyShape shape = shapesList.get(alterindex);
		int x1 = shape.getX1();
		int x2 = shape.getX2();
		int y1 = shape.getY1();
		int y2 = shape.getY2();
		System.out.println("index: " + alterindex + "  size: " + shapesList.size());
		MyShape newshape = null;
		
		switch (rint(3)) {
		case 0:
			newshape = new MyEllipse(x1,y1,x2,y2);
			break;
		case 1:
			newshape = new MyLine(x1,y1,x2,y2);
			break;
		case 2:
			newshape = new MyRectangle(x1,y1,x2,y2);
			break;
		}
		
		shapesList.set(alterindex, newshape);
		repaint();
		alterindex++;
	}
	
	public void DeleteShape() {
		// Deletes last shape
		if (shapesList.size() != 0) {
			System.out.println(shapesList.size() - 1);
			shapesList.remove(shapesList.size() -1);
			repaint();
		}
	}
	
	public DrawingPanel() {
		super();
		MouseHandler mh = new MouseHandler(this);
		this.addMouseListener(mh);
		this.addMouseMotionListener(mh);
	}

	public void ChangeColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		for (MyShape s : shapesList)
			s.draw(g2d);
	}
}
