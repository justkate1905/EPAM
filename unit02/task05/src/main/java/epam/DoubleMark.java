package epam;

import java.util.Comparator;

/**
 * Created by Katerina on 02.03.2017.
 */
public class DoubleMark extends Mark<Double> implements Comparator<DoubleMark> {


    public DoubleMark(double _mark) {
        super(_mark);
    }

    public int compare(DoubleMark o1, DoubleMark o2) {
        return Double.compare(o1.getMark(),o2.getMark());
    }
}
