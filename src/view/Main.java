package view;

/**
 *
 * @author Joao
 */

import javax.swing.JOptionPane;

import java.util.ArrayList; //Provisorio
import model.Token;
import control.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args){
        String dir = JOptionPane.showInputDialog(null, "Digite o diretório do arquivo: ");
        ArrayList<Token> tokens_lidos = null;
        try {
            LeitorDeTexto lt = LeitorDeTexto.initialize(dir);
            tokens_lidos = lt.read_file();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Falha ao tentar acessar o arquivo");
        }
        
        for(Token token : tokens_lidos){
            System.out.println(token.get_word());
        }
    }
    
}
