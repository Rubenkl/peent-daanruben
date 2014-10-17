import javax.swing.*;

import java.awt.*;

/**
 * Created by Daan on 8-10-2014.
 */
public class RightPanel extends JPanel {
	int rectanglecount = 0, linecount = 0, ellipsecount = 0;

    DefaultListModel listModel = new DefaultListModel();
    JList shapeList = new JList(listModel);

    RightPanel() {
        super();
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(120, getHeight()));
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        shapeList.setLayoutOrientation(JList.VERTICAL);
        shapeList.setVisibleRowCount(-1);
        add(shapeList);

    }

    public void addToShapeList(MyShape shape) {
    	int currcount;
		switch(shape.type) {
			case "Rectangle":
				rectanglecount++;
				currcount = rectanglecount;
				break;
			case "Line":
				linecount++;
				currcount = linecount;
				break;
			case "Ellipse":
				ellipsecount++;
				currcount = ellipsecount;
				break;
			default:
				currcount = 0;
				break;
		}
        listModel.addElement(shape.type + " " + currcount);
    }
    
    public void deleteFromList(MyShape shape) {
    	listModel.remove(shape.identifier-1);
    }

}
