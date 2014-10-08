import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Window extends JFrame {

    DrawingPanel rp = new DrawingPanel();
    ButtonPanel bp = new ButtonPanel(rp);
    RightPanel rightPanel = new RightPanel();

	public Window() {
		super();
		super.setTitle("Callbacks");
		super.setSize(new Dimension(800, 600));
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setLayout(new BorderLayout());;
		
		//todo: add elements to the content pane


		//place panel in center
		super.getContentPane().add(rp, BorderLayout.CENTER);
		
		//place buttonpanel in the top
		super.getContentPane().add(bp, BorderLayout.NORTH);
		
		add(rightPanel, BorderLayout.EAST);
		rp.setRightPanel(rightPanel);
		super.setVisible(true);
	}


}
