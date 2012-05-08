/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package ch.h2m.edu.nosql.mongodb;

import com.mongodb.*;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class NoSQLTest {
    
    @Mock Mongo mongo;
    @Mock DB db;
    @Mock DBCollection collection;

    NoSQL client;

    public NoSQLTest() {
    }
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        client = new NoSQL();
        client.mongo = mongo;
        client.db = db;
        client.collection = collection;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writeDocument method, of class NoSQL.
     */
    @Test
    public void writeDocument() {
        String id = java.util.UUID.randomUUID().toString();
        String text = this.getClass().getSimpleName();
        ArgumentCaptor<BasicDBObject> argument = ArgumentCaptor.forClass(BasicDBObject.class);
        
        client.writeDocument(id, text);
        
        verify(collection).insert(argument.capture());
        assertTrue(argument.getValue().get("id").equals(id));
        assertTrue(argument.getValue().get("msg").equals(text));
    }
    
//    @Test
    public void readMsg() {
        String id = java.util.UUID.randomUUID().toString();
        String text = this.getClass().getSimpleName();
        
        DBCursor cursor = mock(DBCursor.class);
        DBObject answer = mock(DBObject.class);
        
        when(collection.find( any(BasicDBObject.class) ) ).thenReturn(cursor);
        when(cursor.hasNext()).thenReturn(true).thenReturn(false);
        when(cursor.next()).thenReturn(answer);
        when(answer.get("msg")).thenReturn(text);
        
        client.getResultforId(id);
        
        fail("?? whats wrong?");
        
    }
        
}
