import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel {
	public ButtonPanel(RectPanel rp) {
		super();
		JButton b = new JButton("Change color!");
		this.add(b);
		b.addActionListener(new ButtonHandler(rp));
		
		JButton add = new JButton("Add");
		this.add(add);
		add.addActionListener(new ButtonHandler(rp));
		
		JButton mod = new JButton("Mod");
		this.add(mod);
		mod.addActionListener(new ButtonHandler(rp));
		
	}
}
