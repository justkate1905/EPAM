package epam;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;


class GroupsTest extends TestCase {

    Student John = new Student("John");
    Student Steve = new Student("Steve");

    @Test
    public void testCreatingStudentsAndAddingRightTypeOfMarks() {
        John.addDisciplineWithMark(Disciplines.ENGLISH, new IntegerMark(5));
        John.addDisciplineWithMark(Disciplines.MATHEMATICS, new DoubleMark(2.5));
        assertTrue(John.getMarks().containsKey(Disciplines.ENGLISH));
        assertTrue(John.getMarks().containsKey(Disciplines.MATHEMATICS));

    }
    @Test
    public void testAddingWrongTypeOfMarksWithException() {
        DoubleMark d = new DoubleMark(4.5);
        try {
            John.addDisciplineWithMark(Disciplines.ENGLISH,d);
        }
        catch (IllegalArgumentException e){
            assertTrue(e.getMessage().equals("Type of mark doesn't match to the discipline"));
        }
    }

    @Test
    public void testThatWeCanFormGroupOnlyByOneDiscipline(){
        Student Mark = new Student("Mark");
        Mark.addDisciplineWithMark(Disciplines.MATHEMATICS, new DoubleMark(7.0));

        John.addDisciplineWithMark(Disciplines.ENGLISH, new IntegerMark(5));
        Steve.addDisciplineWithMark(Disciplines.ENGLISH, new IntegerMark(7));

        Group english = new Group(Disciplines.ENGLISH,"Y123");

        english.addStudent(John, Steve,Mark);
        assertTrue(english.getStudents().contains(John));

        assertFalse(english.getStudents().contains(Mark));

    }
}