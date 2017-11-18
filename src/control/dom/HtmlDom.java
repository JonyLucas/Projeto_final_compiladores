package control.dom;

/**
 *
 * @author Joao
 */
import java.io.IOException;
import control.analisadores.AnalisadorGramatical;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class HtmlDom {

    public static String[] get_gramatical_class(String token) throws IOException {
        
        Document doc = Jsoup.connect("http://www.dicio.com.br/" + token + "/").get();
        Elements content = doc.getElementsByClass("adicional");
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

        return gramatical_classes;
    }
    
    public static String[] get_synonyms(String token) throws IOException{
        Document doc = Jsoup.connect("http://www.sinonimos.com.br/" + token + "/").get();
        Elements result = doc.getElementsByClass("sinonimo");
        
        int size = result.size();
        int i = 0;
        
        String[] synonyms = new String[size];
        
        for(Element element : result){
            //System.out.println(element.text());
            synonyms[i] = element.text();
            i++;
        }
        
        return synonyms;
        
    }

}
