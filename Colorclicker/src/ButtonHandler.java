import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class ButtonHandler implements ActionListener {
	private RectPanel rec;
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if (cmd == "Add") {
			System.out.println("Add was pressed.");
			rec.addRandomShape();
			
		} else if (cmd == "Mod") {
			System.out.println("Mod was pressed.");
			rec.alterNextShape();
		} else {
		
			//todo: add code here that will be ran when buttonclick.
			Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color random = new Color(r, g, b);
			rec.ChangeColor(random);
			rec.repaint();
		}
	}
	public ButtonHandler (RectPanel rp) {
		rec = rp;
	}

}
