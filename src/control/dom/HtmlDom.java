package control.dom;

/**
 *
 * @author Joao
 */
import java.io.IOException;
import model.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class HtmlDom {

    private static String url;

    public static void setUrl(String url) {
        HtmlDom.url = url;
    }

    public static String[] get_gramatical_class(Token token) throws IOException {
        
        Document doc = Jsoup.connect("http://www.dicio.com.br/" + token.get_word() + "/").get();
        Element content = doc.getElementById("content");
        Elements result = content.getElementsByTag("span");
        
        int size = result.size();
        int i = 0;
        
        if(size == 0){
            System.out.println("VAZIO");
        }
        
        String[] gramatical_classes = new String[size];
        
        for (Element element : result) {
            String key = element.attr("class");
            if ("cl".equals(key)) {
                //System.out.println(element.text());
                gramatical_classes[i] = element.text();
                i++;
            }
        }

        return gramatical_classes;
    }
    
    public static String[] get_synonyms(Token token) throws IOException{
        Document doc = Jsoup.connect("http://www.sinonimos.com.br/" + token.get_word() + "/").get();
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
