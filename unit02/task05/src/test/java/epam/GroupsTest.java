package epam;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class GroupsTest extends TestCase {
    @Test
    public void testCreatingStudentsAndAddingRightTypeOfMarks() {
        Student John = new Student("John");
        John.addDisciplineWithMark(Disciplines.ENGLISH, new IntegerMark(5));
        John.addDisciplineWithMark(Disciplines.MATHEMATICS, new DoubleMark(2.5));
        John.addDisciplineWithMark(Disciplines.HISTORY, new IntegerMark(7));
        assertTrue(John.getMarks().containsKey(Disciplines.ENGLISH));
    }
}