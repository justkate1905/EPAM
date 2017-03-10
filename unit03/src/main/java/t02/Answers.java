package t02;

import java.util.ResourceBundle;

/**
 * Created by Katerina on 10.03.2017.
 */
public class Answers extends ClassWithBundle {

    public Answers(){
        bundle = ResourceBundle.getBundle("answers", Language.locale);

    }

    public String getAnswer(String num){
        return bundle.getString(num);
    }
}
