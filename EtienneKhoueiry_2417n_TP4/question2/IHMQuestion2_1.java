package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_1 extends JFrame implements ActionListener{

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");
    
    private TextArea contenu = new TextArea(30, 80);
    private JButtonObserver jbo1 = new JButtonObserver("jbo1" , contenu);
    private JButtonObserver jbo2 = new JButtonObserver("jbo2" , contenu);
    private JButtonObserver jbo3 = new JButtonObserver("jbo3" , contenu);
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();
        
        boutonA.addActionListener(this);
        
        boutonB.addActionListener(this);
     
        boutonC.addActionListener(this);
        
        // à compléter
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3

        // le bouton B a 2 observateurs jbo1 et jbo2

        // le bouton C a 1 observateur jbo1

      
    }
    public void actionPerformed(ActionEvent evt){
        String s = evt.getActionCommand();
        if(s.equals("A")){
            contenu.setText("");
            jbo1.actionPerformed(evt);
            jbo2.actionPerformed(evt);
            jbo3.actionPerformed(evt);
        }
        if(s.equals("B")){
            contenu.setText("");
            jbo1.actionPerformed(evt);
            jbo2.actionPerformed(evt);
        }
        if(s.equals("C")){
            contenu.setText("");
            jbo1.actionPerformed(evt);
        }
    }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }
    
}