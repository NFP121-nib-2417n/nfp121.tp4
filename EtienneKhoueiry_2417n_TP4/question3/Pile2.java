package question3;

import question3.PilePleineException;
import question3.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;
    final int capaciteParDefault = 10;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        // à compléter
        if(taille <= 0){
           capacite = capaciteParDefault;
        }else{
            Stack t = new Stack<T>();
            this.stk = t;
            this.capacite = taille;
        }
        
        
    }

    public Pile2(){
        new Pile2(0);
    }

    public void empiler(T o) throws PilePleineException{
        // à compléter
        if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);        
    }

    public T depiler() throws PileVideException{
        // à compléter
        if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        // à compléter
        return stk.peek();
    }
    public boolean estPleine(){
        return stk.size() == capacite;
    }
    
    public boolean estVide(){
        return stk.size() == 0;
    }
    public boolean equals(Object o){
        return true;
    };
    public int hashCode(){
        return toString().hashCode();
    };
    public String toString(){
        String s = "[";
        while(!this.stk.empty()){
            s += this.stk.peek();
            if (this.stk.size() > 1)
                s += ", ";
        }

        return s + "]";
    };
    public int taille(){
        return this.stk.size();
    };
    public int capacite(){
        return this.capacite;
    };
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2