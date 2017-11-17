package control.leitores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


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
    
    public ArrayList<String> read_file(){
        String word;
        ArrayList<String> tokens = new ArrayList<String>();
        
        while(scan.hasNext()){
            word = scan.next();
            tokens.add(word);
        }
        
        scan.close();
        
        return tokens;
    }
    
        
    
}
