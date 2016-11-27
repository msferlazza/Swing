package ch.ibw.swing.uebungen;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class CSVJTableExample extends JFrame {

    private JTable table;
    private JButton btnAction;

    public CSVJTableExample()
    {
        super("CSVJTableExample");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnAction = new JButton("Dateiauswahl");
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e)
            {


            }
        });

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnAction, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(final String[] args)
    {
        new CSVJTableExample();
    }

    private TableModel parseCSVAndCreateTableModel(final File file)
    {
        return null;
    }

}
