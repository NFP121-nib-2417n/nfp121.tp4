package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_2 extends MouseAdapter implements ActionListener{
    JFrame frame = new JFrame("IHM Question2_2"); 
    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

    private JButtonObserver jbo1 = new JButtonObserver("jbo1" , contenu);
    private JButtonObserver jbo2 = new JButtonObserver("jbo2" , contenu);
    private JButtonObserver jbo3 = new JButtonObserver("jbo3" , contenu);
 
    
    private JMouseObserver jmo1 = new JMouseObserver("jmo1", contenu);
    private JMouseObserver jmo2 = new JMouseObserver("jmo2", contenu);
    private JMouseObserver jmo3 = new JMouseObserver("jmo3", contenu);
    
    public IHMQuestion2_2() {
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        frame.setLayout(new BorderLayout(5, 5));
        frame.add("North", enHaut);
        frame.add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        frame.setLocation(150,150);frame.pack();frame.show();
        enHaut.setBackground(Color.magenta);
        

        // à compléter à l'identique de la question 2_1, (du copier/coller)...
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3

        // le bouton B a 2 observateurs jbo1 et jbo2

        // le bouton C a 1 observateur jbo1

        // à compléter pour la question 2_2 (JMouseObserver)
            // le bouton A a 1 observateur jmo1
            // le bouton B a 1 observateur jmo2
            // le bouton C a 1 observateur jmo3
        boutonA.addActionListener(this);
    
        boutonB.addActionListener(this);
    
        boutonC.addActionListener(this);
        
        boutonA.addMouseListener(this);
        boutonB.addMouseListener(this);
        boutonC.addMouseListener(this);
        
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
        public void mouseEntered(MouseEvent e) {
            	Object obj = e.getSource();
            	if(obj instanceof JButton){
                    JButton btn = (JButton) obj;
                    String s = btn.getText();
                    if(s.equals("A")){
                        jmo1.mouseEntered(e);
                    }
                    if(s.equals("B")){
                        jmo2.mouseEntered(e);
                    }
                    if(s.equals("C")){
                        jmo3.mouseEntered(e);
                    }
                }
        }

	
     public static void main(String[] args){
        //new IHMQuestion2_1();
        new IHMQuestion2_2();
    }


}