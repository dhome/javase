package ch.h2m.edu.patternplayground.singleton;

/**
 * SingletonHolder.java
 *
 * Created on 08.11.2011, 14:18:58
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class SingletonHolder extends Counter {

    /**
     * Privater Konstruktor verhindert externe Instanzierung
     */
    private SingletonHolder() {
        super();
    }

    /**
     * Innere statische Holder-Klasse
     */
    private static class Holder {

        private static final SingletonHolder INSTANCE = new SingletonHolder();

        private Holder() {
        }
    }

    /**
     * Statische Factory-Methode
     */
    public static SingletonHolder getInstance() {
        return Holder.INSTANCE;
    }
}
