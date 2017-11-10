/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
public class HtmlDomTest {
    
    public HtmlDomTest() {
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
     * Test of getName method, of class HtmlDom.
     */
    @Test
    public void testGetName() throws Exception {
        System.out.println("getName");
        String url = "https://www.dicio.com.br/corrida/";
        HtmlDom.setUrl(url);
        HtmlDom.getName();
    }
    
}
