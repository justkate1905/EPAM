package epam.java.se;

//import junit.framework.TestCase;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("Since15")
public class IntArrayListTest{
    @Test
    public void testNonRecursiveSortMethod() throws Exception {
        final int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        final int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        final IntArrayList list = new IntArrayList(ints);
        list.sort2();

        assertArrayEquals(expected,list.getData());
    }

    @Test
    public void testAllPossibilitiesOfTheCycleBinarySearch() throws Exception {
        final int[] ints = {-13,-1, 0, 0, 1,2, 12, 56, 56, 56, 120, 666};
        Arrays.sort(ints);
        final IntArrayList list = new IntArrayList(ints);
        assertEquals(0,list.binarySearch(-13));
        assertEquals(-13,list.binarySearch(667));
        assertEquals(-8,list.binarySearch(30));
        assertEquals(-1,list.binarySearch(-260));
        assertEquals(-1,list.binarySearch(-26));


    }

    @Test
    public void binarySearchCanFindRightElements() throws Exception {
        final int[] ints = {-13,-1, 0, 0, 1,2, 12, 56, 56, 56, 120, 666,Integer.MIN_VALUE};
        Arrays.sort(ints);
        final IntArrayList list = new IntArrayList(ints);
        assertEquals(1,list.binarySearch(-13));
    }

    @Test
    public void binarySearchReturnRightValueIfElementIsAbsent() throws Exception {
        final int[] ints = {-13,-1, 0, 0, 1,2, 12, 56, 56, 56, 120, 666,Integer.MAX_VALUE};
        Arrays.sort(ints);
        final IntArrayList list = new IntArrayList(ints);
        assertEquals(-1,list.binarySearch(-26));
        assertEquals(-7,list.binarySearch(3));

    }

    @Test
    public void testThatMethodSortInTheRightWay() throws Exception {
        final int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        final int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        final IntArrayList list = new IntArrayList(ints);
        list.sort();
        assertArrayEquals(expected, list.getData());
    }
}