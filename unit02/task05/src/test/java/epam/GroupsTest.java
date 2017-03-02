package epam;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.*;

import static epam.Disciplines.*;


class GroupsTest extends TestCase {
    Groups groups = new Groups();
    Student John = new Student("John");
    Student Steve = new Student("Steve");
    Student Mark = new Student("Mark");
    Student Helen = new Student("Helen");
    Student Stan = new Student("Stan");
    Student Dean = new Student("Dean");

    Group english = new Group(ENGLISH,"Y123");
    Group math = new Group(Disciplines.MATHEMATICS,"Y124");
    Group programming = new Group(Disciplines.PROGRAMMING,"Y125");

    public Groups testDataCreating(){
        Groups groups = new Groups();
        groups.addGroups(english,math,programming);

        Mark.addDiscipline(ENGLISH, MATHEMATICS, PHYSIC);
        John.addDiscipline(PROGRAMMING, PSYCHOLOGY);
        Steve.addDiscipline(HISTORY, MATHEMATICS);
        Helen.addDiscipline(PROGRAMMING, PSYCHOLOGY, PHYSIC);
        Dean.addDiscipline(HISTORY, MATHEMATICS, ENGLISH);
        Stan.addDiscipline(ENGLISH, MATHEMATICS, PHYSIC);

        groups.addStudents(Mark,John,Steve,Helen,Dean,Stan);
        return groups;
    }
    public void testAddingMarks(){
        Mark.addDisciplineWithMark(ENGLISH, new IntegerMark(5),new IntegerMark(6),new IntegerMark(8));
        Dean.addDisciplineWithMark(ENGLISH,new IntegerMark(6),new IntegerMark(9));
        Stan.addDisciplineWithMark(ENGLISH, new IntegerMark(10),new IntegerMark(7),new IntegerMark(5));
    }

    public void printStatistic(Map<Student, Double> statistic){
        StringBuilder sb = new StringBuilder();

        Iterator<Map.Entry<Student, Double>> iter = statistic.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<Student, Double> entry = iter.next();
            sb.append(entry.getKey().getName());
            sb.append(':').append('"');
            sb.append(entry.getValue());
            sb.append('"');
            if (iter.hasNext()) {
                sb.append(',').append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testCreatingStudentsAndAddingRightTypeOfMarks() {
        John.addDisciplineWithMark(PSYCHOLOGY, new IntegerMark(5));
        John.addDisciplineWithMark(MATHEMATICS, new DoubleMark(2.5));

        assertTrue(John.getMarks().containsKey(PSYCHOLOGY));
        assertTrue(John.getMarks().containsKey(MATHEMATICS));

    }
    @Test
    public void testAddingWrongTypeOfMarksWithException() {
        DoubleMark d = new DoubleMark(4.5);
        try {
            John.addDisciplineWithMark(PSYCHOLOGY,d);
        }
        catch (IllegalArgumentException e){
            assertTrue(e.getMessage().equals("Type of mark doesn't match to the discipline"));
        }
    }

    @Test
    public void testThatWeCanFormGroupOnlyByOneDiscipline(){
        Mark.addDisciplineWithMark(MATHEMATICS, new DoubleMark(7.0));
        John.addDisciplineWithMark(PSYCHOLOGY, new IntegerMark(5));
        Steve.addDisciplineWithMark(HISTORY, new IntegerMark(7));

        math.addStudent(John,Mark,Steve);

        assertTrue(math.getStudents().contains(Mark));
        assertFalse(math.getStudents().contains(Steve));

    }

    @Test
    public void testWeCanSearchGroupsForStudents(){
        Groups newGroup = testDataCreating();
        assertTrue(newGroup.findStudentGroups(Stan).contains(english));
    }

    @Test
    public void testForFindingGroupsForStudentsAndCompareTheirMarks(){
        Groups groups = testDataCreating();
        testAddingMarks();

        List<Group> groupsForStudent = groups.findStudentGroups(Mark);
        Map<Student, Double> statisticForGroup = new HashMap<Student, Double>();

        Map<Disciplines, Map<Student, Double>> averageStatistic = new HashMap<Disciplines, Map<Student, Double>>();

        for(Group g:groupsForStudent){
            for(Student s: g.getStudents()){
                statisticForGroup.put(s,s.calculateAverage(g.getDisciplines()));
            }
            averageStatistic.put(g.getDisciplines(),statisticForGroup);
        }

        printStatistic(averageStatistic.get(MATHEMATICS));

        assertEquals(averageStatistic.get(ENGLISH).get(Mark), Mark.calculateAverage(ENGLISH));

    }
}