package ch.h2m.edu.nosql.cassandra;


import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ColumnFamilyUpdater;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.ddl.ColumnFamilyDefinition;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class NoSQLTest {
    
    
    @Mock Cluster myCluster;
    @Mock ColumnFamilyDefinition cfDef;
    @Mock ColumnFamilyTemplate<String, String> template;
    Hector hector;
    
    public NoSQLTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        hector = new Hector();
        hector.cfDefJms = cfDef;
        hector.myCluster = myCluster;
        hector.template_jms = template;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Hector.
     */
    @Test
    public void createAnEntry() {
        String entry = "dummy";
        ColumnFamilyUpdater<String, String> updater = mock(ColumnFamilyUpdater.class);
        when(template.createUpdater(hector.COLUMNFAMILYNAME_JMS)).thenReturn(updater);
        hector.updateJms(entry);
        verify(updater, times(1)).setString("value", entry);     
    }
    
    @Test
    public void readAnEntry() {
        String entry = "dummy";
        ColumnFamilyResult<String, String> res = mock(ColumnFamilyResult.class);
        when(template.queryColumns(hector.COLUMNFAMILYNAME_JMS)).thenReturn(res);
        when(res.getString("value")).thenReturn(entry);
        
        String result = hector.getJms();
        assertTrue(result.equals(entry));
    }    
}
