import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Handles all text.
 * Text is stored in properties files.
 */
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

    /**
     * Return text based on key.
     * @param key
     * @return Text
     */
    public String getMessages(String key){
        return messages.getString(key);
    }
}