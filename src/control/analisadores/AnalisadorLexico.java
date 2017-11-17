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
import control.dom.HtmlDom;
import infra.Container;
import java.io.IOException;
import model.Token;

public class AnalisadorLexico {
    
    private static ArrayList <String> words_list;
    private static AnalisadorLexico al = null;
    
    
    private AnalisadorLexico(ArrayList<String> token_list){
        words_list = token_list;
    }
    
    
    /**Utiliza o padrão singleton**/
    public static synchronized AnalisadorLexico get_instance(ArrayList<String> token_list){
        if(al == null){
            al = new AnalisadorLexico(token_list);
        }
        
        return al;
    }
    
    public void analisar(){
        
        int pos = 1;
        
        try{
            for(String word : words_list){
                
                Token token = new Token(word, pos);
                pos++;
                
                //Faz a classificação gramatical e pega os sinonimos em um thesaurus
                token.add_synonym(HtmlDom.get_synonyms(word));
                token.set_gramatical_class(HtmlDom.get_gramatical_class(word));
                
                //armazena o token no container (Uma abstraçao para armazenamento)
                Container.add(token);
            }
            
        }catch(IOException ioe){
            System.out.println("Ocorreu um erro!");
            ioe.printStackTrace();
        }
    }
    
    
}
