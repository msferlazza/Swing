package ch.ibw.swing.folien;

import javax.swing.*;
import java.awt.*;

public class VerticalBoxTest {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Vertical Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box box = Box.createVerticalBox();
        box.add(new JButton("Top"));
        box.add(Box.createVerticalStrut(25));
        box.add(new JButton("Middle"));
        box.add(Box.createVerticalStrut(10));
        box.add(new JButton("Bottom"));
        frame.add(box, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
