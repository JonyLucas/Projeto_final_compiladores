package view;

/**
 *
 * @author Joao
 */

import control.analisadores.Analisador;
import control.dom.HtmlDom;
import control.modificador.ModificadorDeSentencas;
import infra.Container;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) throws IOException{
        //String dir = JOptionPane.showInputDialog(null, "Digite o diretório do arquivo: ");
        Analisador.analisar("input.txt");
        System.out.println("Claim: ");
        for (int i = 0; i < Container.get_size(); i++){
            System.out.print(Container.get(i).get_word() + " ");
        }
        
        System.out.println("\n\nAll words described: ");
        Container.list_all();
        
        //Cria sentença com sinônimo e modifica ordem na conjunção aditiva
        System.out.println("\nModified Sentence: ");
        System.out.println(ModificadorDeSentencas.setConjuncaoAditiva(ModificadorDeSentencas.getModifiedSentence()));
        
        //Imprime o snippet com a quantia de resultados
        System.out.println("\nSnippet: ");
        HtmlDom.getSnippet(ModificadorDeSentencas.setSentenceToSearch());
    }
    
}
