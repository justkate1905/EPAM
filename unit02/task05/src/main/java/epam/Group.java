package epam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 02.03.2017.
 */
public class Group {
    private Disciplines d;
    private String name;
    private String groupID;
    private List<Student> students;

    public Group(){

    }
    public Group(Disciplines _d, String _groupID){
        d = _d;
        name = _d.name;
        groupID = _groupID;
        students = new ArrayList<Student>();
    }

    public void addStudent(Student ... student){
        for(Student s: student){
            if(s.getMarks().containsKey(d)){
                students.add(s);
            }
        }
    }

    public boolean isContainsStudent(String name){
        for(Student s:students){
            if(s.getName().equals(name))
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getGroupID() {
        return groupID;
    }

    public List<Student> getStudents() {
        return new ArrayList<Student>(students);
    }

}
