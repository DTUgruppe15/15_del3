import java.util.Locale;
import java.util.ResourceBundle;

public class Languages {

    static Locale currentLocale = new Locale("en", "US");
    static ResourceBundle messages;

    public Languages(){
        messages = ResourceBundle.getBundle("Languages", currentLocale);
    }

    public static void setLanguages(String language, String country){
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("Languages",currentLocale);
    }

    public String getMessages(String key){
        return messages.getString(key);
    }
}