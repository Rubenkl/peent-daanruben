import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyLine extends MyShape {
	
	public MyLine() {
		super();
		type = "Line";
	}
	
	public MyLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Line2D.Double line = new Line2D.Double(x1, y1, x2,
				y2); // was originaal x1, x2, y1, y2
		g.draw(line);
	}

    boolean contains(int x, int y) {
        if(x1 < x && x < x2 && y2 > y && y > y1) {
            return true;
        }
        return false;
    }

}
