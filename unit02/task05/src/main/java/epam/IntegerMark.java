package epam;

import java.util.Comparator;

/**
 * Created by Katerina on 02.03.2017.
 */
@SuppressWarnings("ALL")
public class IntegerMark extends Mark<Integer> implements Comparator<IntegerMark> {
    public IntegerMark(int _mark) {
        super(_mark);
    }

    public int compare(IntegerMark o1, IntegerMark o2) {
        return Integer.compare(o1.getMark(),o2.getMark());
    }
}
