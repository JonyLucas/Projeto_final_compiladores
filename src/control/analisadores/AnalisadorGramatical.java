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
public class AnalisadorGramatical {
    
    public static boolean is_gramatical_class(String word){
        if(word.contains("substantivo") || word.contains("verbo") || word.contains("adjetivo") || word.contains("pronome") || (word.contains("artigo")) ||
           word.contains("numeral") || word.contains("preposição") || word.contains("conjunção") || word.contains("interjeição") || word.contains("advérbio"))
            return true;
        else
            return false;
    }
}
