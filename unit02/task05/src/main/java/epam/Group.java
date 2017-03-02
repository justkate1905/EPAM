package epam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Katerina on 02.03.2017.
 */
public class Group {
    private Disciplines disciplines;
    private String name;
    private String groupID;
    private List<Student> students;

    public Group(){

    }
    public Group(Disciplines _d, String _groupID){
        disciplines = _d;
        name = _d.name;
        groupID = _groupID;
        students = new ArrayList<Student>();
    }

    public void addStudent(Student ... student){
        for(Student s: student){
            if(s.getMarks().containsKey(disciplines)){
                students.add(s);
            }
        }
    }
    public boolean containsStudent(Student student){
        return students.contains(student);
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

    public Disciplines getDisciplines() {
        return disciplines;
    }
}
