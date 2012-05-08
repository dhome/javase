package ch.h2m.edu.nosql.mongodb;

import ch.h2m.edu.nosql.mongodb.NoSQL;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class NoSQLIT {
    
    public NoSQLIT() {
    }

    @Test
    public void crudProcedure() {
        String id = java.util.UUID.randomUUID().toString();
        String msg = "Hello from " + this.getClass().getSimpleName();
        NoSQL mongoDB = new NoSQL();
        mongoDB.init();
        mongoDB.writeDocument(id, msg);
        List<String> result = mongoDB.getResultforId(id);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        for (String string : result) {
            assertTrue(msg.equals(string));
        }
    }
}
