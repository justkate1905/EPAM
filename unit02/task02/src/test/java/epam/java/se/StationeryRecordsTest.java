package epam.java.se;

import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by Katerina on 27.02.2017.
 */
public class StationeryRecordsTest extends TestCase {
    @Test
    public void testGettingCostOfStationery(){
        Stationery pen = new Stationery("Pen",40);
        Stationery pencil = new Stationery("Pencil", 12);
        Stationery scissor = new Stationery("scissor",43);
        Stationery eraser = new Stationery("eraser",19);

        Employee John = new Employee("John");
        Employee Sam = new Employee("Sam");

        John.addItem(pen,eraser);
        Sam.addItem(pencil,scissor);

        StationeryRecords record = new StationeryRecords();
        record.addEmployee(John, Sam);

        long cost = record.getStationeryCost(Sam);
        assertEquals(55,cost);

    }


}