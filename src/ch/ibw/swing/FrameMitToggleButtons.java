package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit Toggle-Buttons */
public class FrameMitToggleButtons extends JFrame {
  Container c;            // Container dieses Frames
  // Feld fuer Toggle-Buttons, die im Frame erscheinen sollen
  JToggleButton b[] = new JToggleButton[4];
  
  public FrameMitToggleButtons() {  // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen
    
    // Erzeuge die Button-Objekte
    for (int i = 0; i < 4; i++) {
      b[i] = new JToggleButton("Schalter " + (i+1));
      b[i].setFont(new Font("SansSerif",Font.ITALIC,24));
    }
    b[0].setSelected(true);
    b[2].setSelected(true);
    // Fuege die Buttons dem Frame hinzu
    for (int i = 0; i < 4; i++) {
      c.add(b[i]);
    }
  }
  public static void main(String[] args) {
    FrameMitToggleButtons fenster = new FrameMitToggleButtons();
    fenster.setTitle("Frame mit Buttons");
    fenster.setSize(330,130);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
