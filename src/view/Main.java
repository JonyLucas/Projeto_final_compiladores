package view;

/**
 *
 * @author Joao
 */

import control.analisadores.Analisador;
import infra.Container;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args){
        String dir = JOptionPane.showInputDialog(null, "Digite o diretório do arquivo: ");
        Analisador.analisar(dir);
        //Container.list_all();
    }
    
}
