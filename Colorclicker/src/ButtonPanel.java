import javax.swing.*;


public class ButtonPanel extends JPanel {
	public ButtonPanel(DrawingPanel rp) {
		super();
		JButton b = new JButton("Rectangle");
		this.add(b);
		b.addActionListener(new ButtonHandler(rp));
		
		JButton add = new JButton("Line");
		this.add(add);
		add.addActionListener(new ButtonHandler(rp));
		
		JButton mod = new JButton("Ellipse");
		this.add(mod);
		mod.addActionListener(new ButtonHandler(rp));

        JButton delete = new JButton("Delete");
        this.add(delete);
        mod.addActionListener(new ButtonHandler(rp));

        JToggleButton nieuw = new JToggleButton("nieuw");
        this.add(nieuw);

	}
}
