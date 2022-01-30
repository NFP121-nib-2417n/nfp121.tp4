package question3;

import question3.PileI;
import question3.PilePleineException;
import question3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel implements ActionListener{

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(this);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(this);
        boutons.add(add);   add.addActionListener(this);
        boutons.add(sub);   sub.addActionListener(this);
        boutons.add(mul);   mul.addActionListener(this);
        boutons.add(div);   div.addActionListener(this);
        boutons.add(clear); clear.addActionListener(this);
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        // à compléter
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)
    public void actionPerformed(ActionEvent evt){
        
        String e = evt.getActionCommand();
        if(e.equalsIgnoreCase("push")){
            try{
                pile.empiler(Integer.parseInt(donnee.getText()));
                donnee.setText("");
            }catch(Exception excp){
                
            }
            
        }
        if(e.equalsIgnoreCase("+")){
            try{
                int i1 = pile.depiler();
                int i2 = pile.depiler();
                int sum = i1+i2;
                donnee.setText(String.valueOf(sum));
            }catch(Exception excp){
                
            }
            
            
        }
        if(e.equalsIgnoreCase("-")){
            try{
                int i1 = pile.depiler();
                int i2 = pile.depiler();
                int minus = i1-i2;
                donnee.setText(String.valueOf(minus));           
            }catch(Exception excp){
                
            }
            
        }
        if(e.equalsIgnoreCase("*")){
            try{
                int i1 = pile.depiler();
                int i2 = pile.depiler();
                int mult = i1*i2;
                donnee.setText(String.valueOf(mult));
            }catch(Exception excp){
                
            }
            
        }
        if(e.equalsIgnoreCase("/")){
            try{
                int i1 = pile.depiler();
                int i2 = pile.depiler();
                if(i2 == 0){
                    Exception exption = new Exception("Divise par zero non autorise");
                }else{
                    int mult = i1/i2;
                    donnee.setText(String.valueOf(mult));
                }
                
            }catch(Exception excp){
                
            }
            
        }
        if(e.equalsIgnoreCase("[]")){
            while(pile.taille() > 0){
                try{
                    pile.depiler();
                }catch(Exception exp){
                    
                }
            }
        }
    }

}