package epam;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static epam.Disciplines.*;


class GroupsTest extends TestCase {

    Student John = new Student("John");
    Student Steve = new Student("Steve");
    Student Mark = new Student("Mark");
    Student Helen = new Student("Helen");
    Student Stan = new Student("Stan");
    Student Dean = new Student("Dean");

    Group english = new Group(ENGLISH,"Y123");
    Group math = new Group(Disciplines.MATHEMATICS,"Y124");
    Group programming = new Group(Disciplines.PROGRAMMING,"Y125");


    @Test
    public void testCreatingStudentsAndAddingRightTypeOfMarks() {
        John.addDisciplineWithMark(ENGLISH, new IntegerMark(5));
        John.addDisciplineWithMark(Disciplines.MATHEMATICS, new DoubleMark(2.5));
        assertTrue(John.getMarks().containsKey(ENGLISH));
        assertTrue(John.getMarks().containsKey(Disciplines.MATHEMATICS));

    }
    @Test
    public void testAddingWrongTypeOfMarksWithException() {
        DoubleMark d = new DoubleMark(4.5);
        try {
            John.addDisciplineWithMark(ENGLISH,d);
        }
        catch (IllegalArgumentException e){
            assertTrue(e.getMessage().equals("Type of mark doesn't match to the discipline"));
        }
    }

    @Test
    public void testThatWeCanFormGroupOnlyByOneDiscipline(){
        Mark.addDisciplineWithMark(Disciplines.MATHEMATICS, new DoubleMark(7.0));

        John.addDisciplineWithMark(ENGLISH, new IntegerMark(5));
        Steve.addDisciplineWithMark(ENGLISH, new IntegerMark(7));

        Group english = new Group(ENGLISH,"Y123");

        english.addStudent(John, Steve,Mark);
        assertTrue(english.getStudents().contains(John));

        assertFalse(english.getStudents().contains(Mark));
    }

    @Test
    public void testWeCanSearchGroupsForStudents(){
        Groups groups = new Groups();
        groups.addGroups(english,math,programming);

        Mark.addDiscipline(ENGLISH, MATHEMATICS, PHYSIC);
        John.addDiscipline(PROGRAMMING, MATHEMATICS, PSYCHOLOGY);
        Steve.addDiscipline(HISTORY, MATHEMATICS);
        Helen.addDiscipline(PROGRAMMING, PSYCHOLOGY, PHYSIC);
        Dean.addDiscipline(HISTORY, MATHEMATICS, PHYSIC);
        Stan.addDiscipline(ENGLISH, MATHEMATICS, PHYSIC);

        groups.addStudents(Mark,John,Steve,Helen,Dean,Stan);
        assertTrue(groups.findStudentGroups(Stan).contains(english));
    }
}