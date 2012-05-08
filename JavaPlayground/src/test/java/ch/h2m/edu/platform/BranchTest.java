/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.h2m.edu.platform;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author tdmarti
 */
public class BranchTest {
    
    public BranchTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ifcheckUnequal() {
        Branch b = new Branch();
        assertFalse(b.ifcheckUnequal("bla", "bla"));
        assertFalse(b.ifcheckUnequal("", ""));
        assertFalse(b.ifcheckUnequal(null, null));
        assertTrue(b.ifcheckUnequal("000", "bla"));
        assertTrue(b.ifcheckUnequal(null, "bla"));
        assertTrue(b.ifcheckUnequal("bla", null));
    }

    @Test
    public void nullEqual() {
        Branch b = new Branch();
        assertFalse( b.nullcheck(null));
        assertTrue(b.nullcheck("bla"));
    }
}
