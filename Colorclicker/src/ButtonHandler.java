import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class ButtonHandler implements ActionListener {
	private RectPanel rec;
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if (cmd == "Rectangle") {

			System.out.println("Rectangle was pressed.");
			rec.addShape(0);
			
		} else if (cmd == "Line") {
			System.out.println("Line was pressed.");
			rec.addShape(1);
		} else if (cmd == "Ellipse") {
		    rec.addShape(2);
			//todo: add code here that will be ran when buttonclick.
			/*Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color random = new Color(r, g, b);
			rec.ChangeColor(random);
			rec.repaint();*/
		} else {

        }
	}
	public ButtonHandler (RectPanel rp) {
		rec = rp;
	}

}
