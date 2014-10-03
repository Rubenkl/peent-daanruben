/**
 * Created by Daan on 3-10-2014.
 */

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MouseHandler implements MouseListener {

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed (# of clicks: "
                + e.getClickCount() + ")");
    }
}
