import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyEllipse extends MyShape{
	public MyEllipse() {
		super();
		this.type = "Ellipse";
	}
	
	public MyEllipse(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.type = "Ellipse";
	}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Ellipse2D.Double ellipse = new Ellipse2D.Double(startx, starty, width,
				height);
		g.draw(ellipse);
	}

    boolean contains(int x, int y) {
        if(x1 < x && x < x2 && y2 > y && y > y1) {
            return true;
        }
        return false;
    }

}
