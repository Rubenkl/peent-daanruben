import javax.swing.*;
import java.awt.*;

/**
 * Created by Daan on 8-10-2014.
 */
public class RightPanel extends JPanel {

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

    public void addToShapeList(String input) {
        listModel.addElement(input);
    }

}
