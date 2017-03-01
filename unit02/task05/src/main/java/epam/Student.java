package epam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katerina on 01.03.2017.
 */
public class Student {
    private String name;
    private Map<Disciplines, Mark<? extends Number>> marks;

    public Student(){
        name = "John";
        marks = new HashMap<Disciplines, Mark<? extends Number>>();
    }
    public Student(String _name){
        name = _name;
        marks = new HashMap<Disciplines, Mark<? extends Number>>();
    }

    public void addDisciplineWithMark(Disciplines d, Mark<? extends Number> m) {
        if(d.getType()!=m.getMark().getClass()) {
            throw new IllegalArgumentException("Type of mark doesn't match to the discipline");
        }
        else{
            marks.put(d,m);
        }
    }

    public Map<Disciplines, Mark<? extends Number>> getMarks(){
        return new HashMap<Disciplines, Mark<? extends Number>>(marks);
    }

    public String getName(){
        return name;
    }
}
