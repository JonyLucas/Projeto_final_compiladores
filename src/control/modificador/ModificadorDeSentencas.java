/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.modificador;

import control.analisadores.AnalisadorGramatical;
import infra.Container;
import java.util.Random;
import model.Token;

/**
 *
 * @author Nycholas
 */
public class ModificadorDeSentencas {
    
    public static String getNormalSentece(){
        
        int size = Container.get_size();
        String modified = "";
        
        for (int i = 0; i < size; i++){
            Token aux = Container.get(i);
            if (AnalisadorGramatical.is_artigo(aux) || AnalisadorGramatical.is_conjuncao(aux)){
                modified += aux.get_word() + " ";
                continue;
            }
            Random number = new Random();
            int percentage = number.nextInt(2);
            if (percentage == 1){
                modified += aux.get_synonyms().get(0) + " ";
            } else {
                modified += aux.get_word() + " ";
            }
        }
        
        return modified;
    }
}
