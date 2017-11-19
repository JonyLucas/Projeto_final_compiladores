/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.analisadores;

import control.leitores.LeitorDeTexto;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Token;

/**
 *
 * @author Joao
 */
public class Analisador {
    
    private static AnalisadorLexico al;
    private static AnalisadorSintatico as;
    private static LeitorDeTexto lt;
    
    public static void analisar(String file_path)throws GramaticalException{
        
        ArrayList<String> tokens_lidos = null;
        
        /**Faz a leitura do arquivo e divide-o em tokens**/
        
        try {
            lt = LeitorDeTexto.initialize(file_path);
            tokens_lidos = lt.read_file();
        } catch (FileNotFoundException ex) {
            System.out.println("O arquivo não foi encontrado");
        }
        
        if(tokens_lidos == null)
            return;
        
        /**Realiza a classificação gramatical**/
        
        al = AnalisadorLexico.get_instance(tokens_lidos);
        al.analisar();
        as.analisar();        
        
    }
    
}
