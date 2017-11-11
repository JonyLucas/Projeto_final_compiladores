package control;

/**
 *
 * @author Joao
 */
import java.io.IOException;
import model.Token;
import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class HtmlDom {

    private static String url;

    public static void setUrl(String url) {
        HtmlDom.url = url;
    }

    public static String get_gramatical_class(Token token) throws IOException {

        Document doc = Jsoup.connect("http://www.dicio.com.br/" + token.get_word() + "/").get();
        Element loginform = doc.getElementById("content");
        Elements inputElements = loginform.getElementsByTag("span");

        for (Element inputElement : inputElements) {
            String key = inputElement.attr("class");
            if ("cl".equals(key)) {
                System.out.println(inputElement.html());
            }
        }

        return null;
    }

}
