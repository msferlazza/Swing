package ch.ibw.swing.uebungen;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Vector;

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
                TableModel model = parseCSVAndCreateTableModel(getFile());
                table.setModel(model);
            }
        });

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnAction, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public File getFile() {

        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File pathname)
            {
                return pathname.getName().toLowerCase().endsWith("csv");
            }

            @Override
            public String getDescription()
            {
                return "CSV Datei";
            }
        };
        fileChooser.setFileFilter(filter);



        int returnCode = fileChooser.showOpenDialog(this);
        if(returnCode == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public static void main(final String[] args)
    {
        new CSVJTableExample();
    }

    private TableModel parseCSVAndCreateTableModel(final File file)
    {

        final Vector v = new Vector();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));

            // Beschriftungen lesen 1. Zeile in der Datei
            String[] rowItem = br.readLine().split(";");
            final Vector header = new Vector(Arrays.asList(rowItem));

            // alle Zeilen lesen
            while(br.ready()){
                rowItem = br.readLine().split(";");
                v.add( new Vector(Arrays.asList(rowItem)) );
            }

            DefaultTableModel model = new DefaultTableModel(v,header);
            return model;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch(Exception e){
                e.printStackTrace();
            }

        }


        return null;
    }

}
