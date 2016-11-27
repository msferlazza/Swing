
package ch.ibw.swing.taschenrechner;

import javax.swing.*;
import java.awt.*;


/** Die Repraesentionsklasse (View) unseres Taschenrechners erweitert
 *  die Klasse JPanel und erbt damit alle Eigenschaften von JPanel.
 *  Die Repraesentionsklasse ist damit (u.a.) eine (J)Komponente
 *  und kann somit in beliebigen (J)Containern plaziert werden. 
 *   
 */
public class CalculatorView extends JPanel{
    
    /* private Referenz auf die Anzeige des Taschenrechners */ 
    private JTextField anzeige;
    
    public CalculatorView(){
        // Die folgenden beiden Kommentarzeilen muessen wir
        // fuer die letzte Aufgabe wieder einkommentieren
        // +++++++++++++++++++++++++++++++++
        // CalculatorModel cm = new CalculatorModel();
        // CalculatorController cc = new CalculatorController(this,cm);
        
        /* BorderLayout */
        setLayout(new BorderLayout());
       
        /* Anzeige erzeugen und in die Mitte platzieren */
        anzeige = new JTextField();
        add(anzeige,BorderLayout.CENTER);
       
        /* temporaeres Panel erzeugen und im Sueden platzieren */
        JPanel tmp = new JPanel(new GridLayout(4,5));
        add(tmp,BorderLayout.SOUTH);
        
        // Das temporaere Panel muss nun noch mit Inhalt
        // gefuellt werden. Damit eine aehnliche Repraesention
        // wie auf den Folien erreicht wird, dafuer brauchen wir JButtons
        // fuer die Ziffern '0' ... '9' , '.' und Operatoren
        // '+','-','*','-','=','C' sowie (leere) JLabels um nicht
        // benoetigten Luecken im Grid zu fuellen.
        // Hinweis : Das GridLayout wird von links nach rechts und
        // von oben nach unten gefuellt ...
        
       
  
        
             
    }
    
    
    /**
     * Setter Methode um den Anzeigentext zu manipulieren 
     * 
     * @param text - String 
     */
    public void setAnzeige(String text){
        anzeige.setText(text);
    }

  

}
