package control;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Token;

/**
 *
 * @author Joao
 */
public class LeitorDeTexto {
    static private BufferedReader buffer_reader;
    static private LeitorDeTexto reader = null;
    static private Reader file_reader;
    
    private LeitorDeTexto(String path) throws FileNotFoundException{
        file_reader = new FileReader(path);
        buffer_reader = new BufferedReader(file_reader);
    }
    
    /**Segue o padrão singleton, retorna uma instancia unica**/
    public static synchronized LeitorDeTexto initialize(String file_path) throws FileNotFoundException{
        if(reader == null){
            reader = new LeitorDeTexto(file_path);
        }
        return reader;
    }
    
    public ArrayList<Token> read_file(){
        return null;
    }
    
        
    
}
