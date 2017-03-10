package t02;

import java.util.Locale;

/**
 * Created by Katerina on 09.03.2017.
 */
public class Language {
    static String language=null;
    static Locale locale = new Locale("en","US");
    static boolean flag = false;

    public void setLanguage(String choice){
        if(!(choice.equalsIgnoreCase("ru")||choice.equalsIgnoreCase("en"))){
            System.out.println("Choice must be only 'ru' or 'en'. Your choice was "+choice);
        }
        else if(!choice.equalsIgnoreCase(language)){
            language = choice;
            if(choice.equalsIgnoreCase("ru")){
                locale = new Locale("ru","RU");
            }
            else{
                locale = new Locale("en","US");
            }
            flag = true;
        }
    }
}
