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
	int lastshapeindex;
	String command;
	String action;
    RightPanel rightPanel;
    int rectangleCount = 0;
    int lineCount = 0;
    int ellipseCount = 0;
    

    public int getLastShapeIndex() {
    	return shapesList.size() -1;
    	
    }
	
	public void setCommand(String cmd) {
		command = cmd;
	}
	
	public String getCommand() {
		return command;
	}
	
	public int rint(int max) {
		// Deze functie kiest een random integer tussen 0 en max
		Random rand = new Random();
		return rand.nextInt(max);
	}
	
	public void addmouseShape(Point start, Point end, int index) {
		boolean newww;
		if (index == -1) {
			newww = true;
		} else {
			newww = false;
		}
		MyShape shape = null;
		switch(command) {
			case "Rectangle":
	            shape = new MyRectangle(start.x, start.y, end.x, end.y);
	            if (newww) {
	            	rectangleCount++;
	                rightPanel.addToShapeList("Rectangle " + rectangleCount);
	                shapesList.add(shape);
	            } else {
	            	shapesList.set(index, shape);
	            }
	            break;
			case "Line":
				shape = new MyLine(start.x, start.y, end.x, end.y);
				if (newww) {
					lineCount++;
	                rightPanel.addToShapeList("Line " + lineCount);
	                shapesList.add(shape);
	            } else {
	            	shapesList.set(index, shape);
	            }
                
				break;
			case "Ellipse":
				shape = new MyEllipse(start.x, start.y, end.x, end.y);
				if (newww) {
					ellipseCount++;
	                rightPanel.addToShapeList("Ellipse " + ellipseCount);
	                shapesList.add(shape);
	            } else {
	            	shapesList.set(index, shape);
	            }
				break;
			case "Select":
				
				shape = shapesList.get(getSelectedShape(end));
				
				MyShape newshape = null;
				int shapeX1 = shape.getX1() + (end.x - start.x);
				int shapeX2 = shape.getX2() + (end.x - start.x);
				int shapeY1 = shape.getY1() + (end.y - start.y);
				int shapeY2 = shape.getY2() + (end.y - start.y);
				
				System.out.println("shapetype" + shape.type);
				switch(shape.type) {
					case "Rectangle":
						newshape = new MyRectangle(shapeX1, shapeY1, shapeX2, shapeY2);
						break;
					case "Line":
						newshape = new MyLine(shapeX1, shapeY1, shapeX2, shapeY2);
						break;
					case "Ellipse":
						newshape = new MyEllipse(shapeX1, shapeY1, shapeX2, shapeY2);
						break;
					default:
						break;
				}
				if (getSelectedShape(end) != -1) { // als het -1 is heeft hij niks gevonden.
					shapesList.set(getSelectedShape(end), newshape);
				}
				break;
			case "Delete":
				if (getSelectedShape(end) != -1) {
					shapesList.remove(getSelectedShape(end));
				}
				break;
	        default:
	            break;
		}
		repaint();
	}
	
	public int getSelectedShape(Point mousepos) {
		int foundint = -1;
		for (int i = shapesList.size() - 1; i>=0; i--)
		{
			int minx = Math.min(((MyShape)shapesList.get(i)).getX1(), ((MyShape)shapesList.get(i)).getX2());
			int maxx = Math.max(((MyShape)shapesList.get(i)).getX1(), ((MyShape)shapesList.get(i)).getX2());
			int miny = Math.min(((MyShape)shapesList.get(i)).getY1(), ((MyShape)shapesList.get(i)).getY2());
			int maxy = Math.max(((MyShape)shapesList.get(i)).getY1(), ((MyShape)shapesList.get(i)).getY2());
			if (mousepos.x > maxx || mousepos.x < minx || mousepos.y > maxy || mousepos.y < miny)
				continue;
			foundint = i;
			break;
		}
			System.out.println(foundint);
			return foundint;
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

    public void setRightPanel(RightPanel rp){
        rightPanel = rp;
    }


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		for (MyShape s : shapesList)
			s.draw(g2d);
	}
}
