package t04;

import java.io.Serializable;

/**
 * Created by Katerina on 20.03.2017.
 */
public class Actor implements Serializable {
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
