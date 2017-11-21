package control.dom;

/**
 *
 * @author Joao
 */
import java.io.IOException;
import control.analisadores.AnalisadorGramatical;
import model.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class HtmlDom {
    
    public static String[] get_gramatical_class(String token) throws IOException {
        
        //System.out.println(token);
        
        if(AnalisadorGramatical.is_pontuacao(new Token(token))){
            return null;
        }
        
        Document doc = Jsoup.connect("http://www.dicio.com.br/" + token + "/").get();
        
        /**Retira a parte que contem a classificacao gramatical**/
        Elements content = doc.getElementsByClass("adicional");
        
        /**Sem classe gramatical no dicionario**/
        if(!content.text().contains("Classe gramatical:")){
            return get_infinitive_verb(token);
        }
        
        Elements result = content.select("b");
        
        int size = result.size();
        int i = 0;

        String[] gramatical_classes = new String[size];
        
        for(Element element : result){
            if(AnalisadorGramatical.is_gramatical_class(element.text())){
                //System.out.println(element.text());
                gramatical_classes[i] = element.text();
                i++;
            }
        }
        
        if(gramatical_classes.length == 0){
            gramatical_classes = get_infinitive_verb(token);
        }

        return gramatical_classes;
    }
    
    private static String[] get_infinitive_verb(String token) throws IOException{
        
        Document doc = Jsoup.connect("http://www.dicio.com.br/" + token + "/").get();
        Elements content = doc.getElementsByClass("adicional");
        Elements result = content.select("a[href]");
        
        //System.out.println(result.last().text());

        String infinitive_verb = result.last().text();
        
        return get_gramatical_class(infinitive_verb);
    }
    
    public static String[] get_synonyms(String token) throws IOException{
        
        if(AnalisadorGramatical.is_pontuacao(new Token(token))){
            return null;
        }
        
        String[] synonyms;
        
        try{
            Document doc = Jsoup.connect("http://www.dicio.com.br/" + token + "/").get(); //"http://www.sinonimos.com.br/" // "http://www.dicio.com.br/"
            //Elements result = doc.getElementsByClass("sinonimo");
            Elements content = doc.getElementsByClass("adicional sinonimos");
            Elements result = content.first().select("a[href]");
            
            int size = result.size();
            int i = 0;

            synonyms = new String[size];

            for(Element element : result){
                //System.out.println(element.text());
                synonyms[i] = element.text();
                i++;
            }
            
        }catch(NullPointerException npe){
            //System.out.println("Não há sinônimos");
            synonyms = new String[0];
        }
        
        return synonyms;
        
    }

    private static String[] get_inifinitive_verb(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void getSnippet(String search) throws IOException{
        String sentence = "http://www.google.com.br/search?q=" + "\"" + search + "\"";
        
        System.out.println("Link de Pesquisa: " + sentence);
        System.out.print("Quantidade de Resultados: ");
        
        Document doc = Jsoup.connect(sentence).get();
        Elements div = doc.select("div[id=resultStats]");

        
        
        System.out.println(div.text());
    }

}
