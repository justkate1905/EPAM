package epam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 02.03.2017.
 */
public class Group {
    private String name;
    private String groupID;
    private List<Student> students;

    public Group(){

    }
    public Group(String _name, String _groupID){
        name = _name;
        groupID = _groupID;
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student){
        students.add(student);
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
