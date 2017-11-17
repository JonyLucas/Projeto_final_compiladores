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
    
    private AnalisadorLexico al;
    private AnalisadorGramatical ag;
    private LeitorDeTexto lt;
    
    public void analisar(String file_path){
        
        ArrayList<Token> tokens_lidos = null;
        
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
        
        
        
    }
    
}
