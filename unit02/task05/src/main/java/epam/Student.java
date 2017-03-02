package epam;

import java.util.*;

/**
 * Created by Katerina on 01.03.2017.
 */
public class Student {
    private String name;
    private Map<Disciplines, List<Mark<? extends Number>>> marks;

    public Student(){
        name = "John";
        marks = new HashMap<Disciplines, List<Mark<? extends Number>>>();
    }
    public Student(String _name){
        name = _name;
        marks = new HashMap<Disciplines, List<Mark<? extends Number>>>();
    }

    public void addDiscipline(Disciplines ... disciplines){
        List<Mark<? extends Number>> newMarks = new ArrayList<Mark<? extends Number>>();
        for (Disciplines d: disciplines){
            marks.put(d, newMarks);
        }
    }

    public void addDisciplineWithMark(Disciplines d, Mark<? extends Number> ... mark) {
        for (Mark m : mark){
            if(d.getType()!=m.getMark().getClass()) {
                throw new IllegalArgumentException("Type of mark doesn't match to the discipline");
            }
            else {
                if (!marks.containsKey(d)) {
                    addDiscipline(d);
                }
                marks.get(d).add(m);
            }
        }
    }


    public Map<Disciplines,List<Mark<? extends Number>>> getMarks(){
        return new HashMap<Disciplines, List<Mark<? extends Number>>>(marks);
    }

    public String getName(){
        return name;
    }
}
