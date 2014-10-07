import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Window extends JFrame {
	public Window() {
		super();
		super.setTitle("Peent");
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());
		super.setSize(new Dimension(500, 350));
		//super.setSize(new Dimension(xSize, ySize));
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setLayout(new BorderLayout());;
		
		//todo: add elements to the content pane
		DrawingPanel rp = new DrawingPanel();
		ButtonPanel bp = new ButtonPanel(rp);
		
		//place panel in center
		super.getContentPane().add(rp, BorderLayout.CENTER);
		
		//place buttonpanel in the top
		super.getContentPane().add(bp, BorderLayout.NORTH);
		
		
		
		super.setVisible(true);
	}
}
