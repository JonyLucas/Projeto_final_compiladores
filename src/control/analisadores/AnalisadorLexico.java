/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.analisadores;

/**
 *
 * @author Joao
 */

import java.util.ArrayList;
import model.Token;

public class AnalisadorLexico {
    
    private static ArrayList <Token> tokens;
    private static AnalisadorLexico al = null;
    
    
    private AnalisadorLexico(ArrayList<Token> token_list){
        tokens = token_list;
    }
    
    public static synchronized AnalisadorLexico get_instance(ArrayList<Token> token_list){
        if(al == null){
            al = new AnalisadorLexico(token_list);
        }
        
        return al;
    }
    
    public void analisar(){
        for(Token token : tokens){
            
        }
    }
    
    
}
