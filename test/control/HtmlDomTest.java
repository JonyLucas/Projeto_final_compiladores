/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.dom.HtmlDom;
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
    
    @Test
    public void testGet_gramatical_class() throws Exception{
        System.out.println("get gramatical class");
        String[] gramatical_class = HtmlDom.get_gramatical_class("correr");
        
        for(String s : gramatical_class){
            if(s != null)
                System.out.println(s);
        }
    }
    
    @Test
    public void testGet_synonyms() throws Exception{
        System.out.println("get synonyms");
        String[] synonyms = HtmlDom.get_synonyms("inteligente");
        
        for(String s : synonyms){
            System.out.println(s);
        }
        
    }
    
}
