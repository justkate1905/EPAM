package task04;
import task03.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Katerina on 28.02.2017.
 */
public class StationerySorterTest extends TestCase  {
    StationerySorter sorter = new StationerySorter();

    @Test
    public void testSortByCost(){
        StarterStationeryKit kit = new StarterStationeryKit();
        List<StationeryItem> listToSort = kit.getStarterKit();

        sorter.sortByCost(listToSort);

        for (int i =0; i <listToSort.size()-1; i++){
            StationeryItem currentItem = listToSort.get(i);
            StationeryItem nextItem = listToSort.get(i+1);

            assertTrue(currentItem.getPrice() <= nextItem.getPrice());
        }

    }

}