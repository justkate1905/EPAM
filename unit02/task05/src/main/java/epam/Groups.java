package epam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 02.03.2017.
 */
public class Groups {
    private List<Group> groups;

    public List<Group> findStudentGroups(String name){
        List<Group> studentGroups = new ArrayList<Group>();
        for(Group g: groups){
            if(g.isContainsStudent(name)){
                studentGroups.add(g);
            }
        }
        return studentGroups;
    }
}
