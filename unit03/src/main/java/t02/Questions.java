package t02;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Katerina on 10.03.2017.
 */
public class Questions extends ClassWithBundle {

    public Questions(){
        bundle = ResourceBundle.getBundle("questions",Language.locale);
    }

    public static List<String> getQuestions(Language language) {
        List<String> questions = new ArrayList<String>();
        for (String key : bundle.keySet()) {
            if (!key.equals("option")) {
                questions.add(bundle.getString(key));
            }
        }
        System.out.println(bundle.getString("option"));
        return questions;
    }
}
