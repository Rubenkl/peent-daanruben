import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends MyShape {

	public MyRectangle() {
		super();
		this.type = "Rectangle";
	}

	public MyRectangle(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
		this.type = "Rectangle";
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Rectangle2D.Double rect = new Rectangle2D.Double(startx, starty, width,
				height);
		g.draw(rect);
	}

    boolean contains(int x, int y) {
        if(x1 < x && x < x2 && y2 > y && y > y1) {
            return true;
        }
        return false;
    }

}