package t03;

/**
 * Created by Katerina on 06.04.2017.
 */
import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<Integer>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

}
