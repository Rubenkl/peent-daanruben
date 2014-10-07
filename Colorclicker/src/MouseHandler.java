
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
	private DrawingPanel rec;
	Point pstart = null;
	
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed (# of clicks: "
                + e.getClickCount() + ")");
        pstart = e.getPoint();
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Point pend = e.getPoint();
		rec.addmouseShape(pstart, pend);
		
		
	}
	
	public MouseHandler (DrawingPanel rp) {
		rec = rp;
	}

	// ----------------------- MOUSE MOTION ------------------
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//Point pend = e.getPoint();
		//rec.addLine(pstart, pend);
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
