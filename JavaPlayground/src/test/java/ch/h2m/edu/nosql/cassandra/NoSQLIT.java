package ch.h2m.edu.nosql.cassandra;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class NoSQLIT {
    
    public NoSQLIT() {
    }

    @Test
    public void crudOperationJMS() {
        String entry = System.currentTimeMillis() 
                + "-" 
                + this.getClass().getSimpleName();
        Hector cassandra = new Hector();
        cassandra.updateJms(entry);
        
        String result = cassandra.getJms();
        
        assertTrue(entry.equals(result));
    }
    
    @Test
    public void crudOperationLog() {        
        LogRecord[] logRecords = new LogRecord[5];
        logRecords[0] = new LogRecord(Level.OFF, "Level.OFF");
        logRecords[1] = new LogRecord(Level.ALL, "Level.ALL");
        logRecords[2] = new LogRecord(Level.FINE, "Level.FINE");
        logRecords[3] = new LogRecord(Level.WARNING, "Level.WARNING");
        logRecords[4] = new LogRecord(Level.SEVERE, "Level.SEVERE");
        
        for(int i = 0; i < logRecords.length; i++) {
            logRecords[i].setSourceMethodName(getMethodName(2));
            logRecords[i].setSourceClassName(this.getClass().getSimpleName());
        }
        
        Hector cassandra = new Hector();
        
        for(int i = 0; i < logRecords.length; i++) {
            cassandra.createLogEntry(logRecords[i]);
        }
        
        System.out.println( cassandra.getLog() );
    }
    
    /**
     * Get the method name for a depth in call stack. <br />
     * Utility function
     * @param depth depth in the call stack (0 means current method, 1 means call method, ...)
     * @return method name
     */
    public static String getMethodName(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[ste.length - 1 - depth].getMethodName();
        
    }

    
}
