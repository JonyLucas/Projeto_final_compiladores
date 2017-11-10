package control;

/**
 *
 * @author Joao
 */

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class HtmlDom {
    private static String url;
    
    public static void setUrl(String url){
        HtmlDom.url = url;
    }
    
    public static String getName() throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements divs = doc.select("[divs]");
        Element span = doc.select("span").first();
        Elements class_name = doc.select("h3");
        
        HtmlToPlainText formatter = new HtmlToPlainText();
        
        String text = doc.body().text();
        
        System.out.println(text);
        
        return null;
        
    }
    
}
