/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.analisadores;

import java.util.ArrayList;
import model.Token;

/**
 *
 * @author Joao
 */
public class AnalisadorGramatical {
    
    public static boolean is_gramatical_class(String word){
        if(word.contains("substantivo") || word.contains("verbo") || word.contains("adjetivo") || word.contains("pronome") || (word.contains("artigo")) ||
           word.contains("numeral") || word.contains("preposição") || word.contains("conjunção") || word.contains("interjeição") || word.contains("advérbio"))
            return true;
        else
            return false;
    }
    
    public static boolean is_substantivo(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("substantivo")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_verbo(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("verbo")){
                return true;
            }
        }
        
        return false;
    }
    public static boolean is_adjetivo(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("adjetivo")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_pronome(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("pronome")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_artigo(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("artigo")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_numeral(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("numeral")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_preposicao(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("preposição")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_conjuncao(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("conjunção")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_interjeicao(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("interjeição")){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean is_adverbio(Token token){
        ArrayList<String> tokens_gramatical_class = token.get_gramatical_class();
        for(String gramatical_class : tokens_gramatical_class){
            if(gramatical_class.contains("advérbio")){
                return true;
            }
        }
        
        return false;
    }
    
}
