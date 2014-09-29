import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Window extends JFrame {
	public Window() {
		super();
		super.setTitle("Callbacks");
		super.setSize(new Dimension(420, 350));
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setLayout(new BorderLayout());;
		
		//todo: add elements to the content pane
		RectPanel rp = new RectPanel();
		ButtonPanel bp = new ButtonPanel(rp);
		
		//place panel in center
		super.getContentPane().add(rp, BorderLayout.CENTER);
		
		//place buttonpanel in the top
		super.getContentPane().add(bp, BorderLayout.NORTH);
		
		
		
		super.setVisible(true);
	}
}
