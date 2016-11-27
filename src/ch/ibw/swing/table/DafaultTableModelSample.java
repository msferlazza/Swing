package ch.ibw.swing.table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DafaultTableModelSample extends JFrame {
    DefaultTableModel model = new DefaultTableModel(new Object[][] {
            { "some", "text" }, { "any", "text" }, { "even", "more" },
            { "text", "strings" }, { "and", "other" }, { "text", "values" } },
            new Object[] { "Column 1", "Column 2" });

    public DafaultTableModelSample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        pack();
    }

    public static void main(String arg[]) {
        new DafaultTableModelSample().setVisible(true);
    }
}
