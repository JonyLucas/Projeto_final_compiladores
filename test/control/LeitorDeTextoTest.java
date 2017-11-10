/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Token;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao
 */
public class LeitorDeTextoTest {
    
    public LeitorDeTextoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class LeitorDeTexto.
     */
    @Test
    public void testInitialize() throws Exception {
        System.out.println("initialize");
        String file_path = "";
        LeitorDeTexto expResult = null;
        LeitorDeTexto result = LeitorDeTexto.initialize(file_path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read_file method, of class LeitorDeTexto.
     */
    @Test
    public void testRead_file() {
        System.out.println("read_file");
        LeitorDeTexto instance = null;
        ArrayList<Token> expResult = null;
        ArrayList<Token> result = instance.read_file();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
