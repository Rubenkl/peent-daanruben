import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ButtonPanel extends JPanel {
	public ButtonPanel(DrawingPanel rp) {
		
		super();
		JToggleButton rec = new JToggleButton("Rectangle");
		this.add(rec);
		rec.addActionListener(new ButtonHandler(rp));
		
		JToggleButton line = new JToggleButton("Line");
		this.add(line);
		line.addActionListener(new ButtonHandler(rp));
		//add.setActionCommand("Line");

		
		JToggleButton ellipse = new JToggleButton("Ellipse");
		this.add(ellipse);
		ellipse.addActionListener(new ButtonHandler(rp));

		JToggleButton select = new JToggleButton("Select");
		this.add(select);
		select.addActionListener(new ButtonHandler(rp));
		
        JButton delete = new JButton("Delete");
        this.add(delete);
        delete.addActionListener(new ButtonHandler(rp));

        final JButton speak = new JButton("Speak");
        this.add(speak);
        speak.addActionListener(new ActionListener() {
        	Boolean speaking = false;
        	@Override
        	public void actionPerformed(ActionEvent e){
        		if (speaking) {
        			speaking = false;
        			//stop recording
        			speak.setText("Speak");
        		} else {
        			speaking = true;
        			speak.setText("Stop..");
        			//start recording
        		}
        	}
        	
        });

	}
}
