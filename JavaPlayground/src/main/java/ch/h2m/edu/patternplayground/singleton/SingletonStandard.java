package ch.h2m.edu.patternplayground.singleton;

/**
 * SingletonStandard.java
 *
 * Created on 08.11.2011, 14:20:14
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class SingletonStandard extends Counter {
    
        private static final SingletonStandard INSTANCE = new SingletonStandard();
 
        private SingletonStandard() {
            super();
        }
 
        public static SingletonStandard getInstance() {
                return INSTANCE;
        }
}
