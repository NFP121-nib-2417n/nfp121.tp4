package question3;

import question3.PileI;
import question3.PileVideException;
import question3.PilePleineException;

public class PileModele<T> extends  java.util.Observable implements PileI<T> {

    private PileI<T> pile;

    /* à compléter */

    public PileModele(PileI<T> pile) {
        this.pile = pile;
    }

    public void empiler(T o) throws PilePleineException {
      pile.empiler(o);
      setChanged();
      notifyObservers(o);
    }

    public T depiler() throws PileVideException {
        T n = pile.depiler();
        setChanged();
        notifyObservers(n);
        return n;
    }

    public T sommet() throws PileVideException {
        T n = pile.sommet();
        setChanged();
        notifyObservers(n);
        return n;
    }

    public int taille() {
        return pile.taille();
    }

    public int capacite() {
        return pile.capacite();
    }

    public boolean estVide() {
        return pile.estVide();
    }

    public boolean estPleine() {
        return pile.estPleine();
    }

    public String toString() {
        return pile.toString();
    }
}

/**
 * notez qu'un message d'alerte subsiste à la compilation (unsafe ...) dû à
 * l'emploi de notifyObservers, incontournable et sans conséquence ici
 */