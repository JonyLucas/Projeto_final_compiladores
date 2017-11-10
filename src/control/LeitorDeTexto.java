package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Token;

/**
 *
 * @author Joao
 */
public class LeitorDeTexto {
    static private Scanner scan;
    static private LeitorDeTexto reader = null;
    static private File file;
    
    private LeitorDeTexto(String path) throws FileNotFoundException{
        file = new File(path);
        scan = new Scanner(file);
    }
    
    /**Segue o padrão singleton, retorna uma instancia unica**/
    public static synchronized LeitorDeTexto initialize(String file_path) throws FileNotFoundException{
        if(reader == null){
            reader = new LeitorDeTexto(file_path);
        }
        return reader;
    }
    
    public ArrayList<Token> read_file(){
        String word;
        ArrayList<Token> tokens = new ArrayList<Token>();
        
        while(scan.hasNext()){
            word = scan.next();
            tokens.add(new Token(word));
        }
        
        scan.close();
        
        return tokens;
    }
    
        
    
}
