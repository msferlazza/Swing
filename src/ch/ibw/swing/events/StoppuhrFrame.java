package ch.ibw.swing.events;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
/** Erzeuge ein Swing-Fenster mit Stoppuhrfunktion */
public class StoppuhrFrame extends JFrame {
  Container c; 
  JButton   startButton, stoppButton, neuButton;
  JLabel    startZeit, stoppZeit, differenz, status;
  JComboBox ergebnisFormat;
  Date      startZeitObj = null, stoppZeitObj = null;
  Font      schriftGross = new Font("SansSerif",Font.BOLD,20),
            schriftKlein = new Font("SansSerif",Font.BOLD,12);
  SimpleDateFormat 
            form  = new SimpleDateFormat("dd.MM.yy, HH:mm:ss:SS");
  
  public StoppuhrFrame() {  // Konstruktor
    c = getContentPane();
    c.setLayout(new GridLayout(4, 2, 5, 10));
    
    startZeit = new JLabel("--", JLabel.CENTER);
    startZeit.setFont(schriftKlein);
    startZeit.setBorder(new TitledBorder("Startzeit"));
    stoppZeit = new JLabel("--", JLabel.CENTER);
    stoppZeit.setFont(schriftKlein);
    stoppZeit.setBorder(new TitledBorder("Stoppzeit"));
    differenz = new JLabel("--", JLabel.CENTER);
    differenz.setFont(schriftGross);
    differenz.setBorder(new TitledBorder("Laufzeit"));
    
    KnopfListener kL = new KnopfListener();
    
    startButton = new JButton("START");
    startButton.setToolTipText("startet die Stoppuhr");
    startButton.addActionListener(kL);
    stoppButton = new JButton("STOPP");
    stoppButton.setToolTipText("stoppt die Stoppuhr");
    stoppButton.addActionListener(kL);
    neuButton = new JButton("NEU");
    neuButton.setToolTipText("loescht alle Felder");
    neuButton.addActionListener(kL);
    
    ergebnisFormat = new JComboBox();
    ergebnisFormat.addItem("Laufzeit in ms");
    ergebnisFormat.addItem("Laufzeit in min:sec:ms");
    ergebnisFormat.addItemListener(new BoxListener());
    
    status = new JLabel("START druecken!", JLabel.CENTER);
    status.setFont(schriftGross);
    
    stoppButton.setEnabled(false);
    neuButton.setEnabled(false);
    
    c.add(startZeit);
    c.add(startButton);
    c.add(stoppZeit);
    c.add(stoppButton);
    c.add(differenz);
    c.add(neuButton);
    c.add(ergebnisFormat);
    c.add(status);
  }
  // Bestimmung der Laufzeit in ms oder in min:sec:ms als String
  public String differenzString() { 
    long diffZeit = (stoppZeitObj.getTime() - startZeitObj.getTime());
    if (ergebnisFormat.getSelectedIndex() == 0)
      return (diffZeit + " ms");
    else {
      long ms = diffZeit % 1000;
      diffZeit = diffZeit / 1000;
      long s = diffZeit % 60;
      diffZeit = diffZeit / 60;
      long m = diffZeit % 60;
      return (m + ":" + s + ":" + ms);
    }
  }
  // Aktualisierung aller Anzeige-Labels und Buttons
  public void anzeigeAktualisieren() {
    if ((startZeitObj != null) && (stoppZeitObj != null)) {
      startButton.setEnabled(false);
      stoppButton.setEnabled(false);
      neuButton.setEnabled(true);
      startZeit.setText(form.format(startZeitObj));
      stoppZeit.setText(form.format(stoppZeitObj));
      differenz.setText(differenzString());
      status.setText("NEU fuer neuen Stoppvorgang!");
      status.setFont(schriftKlein);
    }
    else if (startZeitObj != null) {
      startButton.setEnabled(false);
      stoppButton.setEnabled(true);
      neuButton.setEnabled(false);
      startZeit.setText(form.format(startZeitObj));
      status.setText("Uhr laeuft!");
      status.setFont(schriftGross);
    }
    else {
      startButton.setEnabled(true);
      stoppButton.setEnabled(false);
      neuButton.setEnabled(false);
      startZeit.setText("--");
      stoppZeit.setText("--");
      differenz.setText("--");
      status.setText("START druecken!");
      status.setFont(schriftGross);
    }
  }
  // Listener fuer die Buttons
  class KnopfListener implements ActionListener { 
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == startButton)
        startZeitObj = new Date();
      else if (e.getSource() == stoppButton)
        stoppZeitObj = new Date();
      else if (e.getSource() == neuButton) {
        startZeitObj = null;
        stoppZeitObj = null;
      }
      anzeigeAktualisieren();
    }
  }
  // Listener fuer die Combo-Box
  class BoxListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
      anzeigeAktualisieren();
    }
  }
  public static void main(String[] args) {
    StoppuhrFrame fenster = new StoppuhrFrame();
    fenster.setTitle("Stoppuhr");
    fenster.setSize(380,250);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
