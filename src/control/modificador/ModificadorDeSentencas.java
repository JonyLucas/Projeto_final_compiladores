/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.modificador;

import control.analisadores.AnalisadorGramatical;
import infra.Container;
import java.util.Arrays;
import java.util.Random;
import model.Token;

/**
 *
 * @author Nycholas
 */
public class ModificadorDeSentencas {
    static String modified = "";
    
    public static String getModifiedSentence(){
               
        for (int i = 0; i < Container.get_size(); i++){
            if (AnalisadorGramatical.is_artigo(Container.get(i)) || AnalisadorGramatical.is_conjuncao(Container.get(i))){
                modified += Container.get(i).get_word() + " ";
                continue;
            }
            Random number = new Random();
            int percentage = number.nextInt(2);
            if (percentage == 1){
                if (Container.get(i).get_synonyms().size() > 0){ //Só troca o sinônimo caso possua ao menos um sinonimo na lista
                    Random number2 = new Random();
                    modified += Container.get(i).get_synonyms().get(number2.nextInt(Container.get(i).get_synonyms().size())) + " ";
                }
                else
                    modified += Container.get(i).get_word() + " ";
            }
            else
                modified += Container.get(i).get_word() + " ";
        }     
        
        return modified;
    }
    
    public static void clear(){
        modified = "";
    }
    
    public static void setConjuncaoAditiva(String modified){
        String modified2 = "";
        String[] words = modified.split(" "); 
        
        for (int i = 0; i < words.length; i++){
            //Verifica se é uma conjunção aditiva
            //Verifica se não vai estourar o for
            //Verifica se a conjunção não é a primeira palavra da frase
            if (AnalisadorGramatical.isConjuncaoAditiva(words[i]) && i <= words.length) {
                if (i < words.length - 1){
                    if (AnalisadorGramatical.is_verbo(Container.get(i + 1)) || AnalisadorGramatical.is_verbo(Container.get(i - 1))){
                        continue;
                    }
                }
                String temp = words[i - 1];
                words[i - 1] = words[i + 1];
                words[i + 1] = temp;
            }
        }
        
        for (String string : words)
            modified2 += string + " ";
        
        System.out.println(modified2);
    }
}
