package epam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 02.03.2017.
 */
public class Groups {
    private List<Group> groups;

    public Groups(){
        groups = new ArrayList<Group>();
    }

    public void addGroups(Group ... group){
        for(Group g : group){
            groups.add(g);
        }
    }

    public void addStudents(Student ... students){
        for(Group g : groups){
            g.addStudent(students);
        }
    }
    public List<Group> findStudentGroups(Student student){
        List<Group> studentGroups = new ArrayList<Group>();
        for(Group g: groups){
            if(g.isContainsStudent(student)){
                studentGroups.add(g);
            }
        }
        return studentGroups;
    }
}
