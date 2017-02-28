package task04;
import task03.*;

import java.awt.event.ComponentAdapter;
import java.util.*;

/**
 * Created by Katerina on 28.02.2017.
 */
@SuppressWarnings("ALL")
public class StationerySorter{

    public void sortByCost(List<StationeryItem> listToSort) {
        Comparator<StationeryItem> comparator = new Comparator<StationeryItem>() {
            public int compare(StationeryItem obj1, StationeryItem obj2) {
                return Long.compare(obj1.getPrice(),obj2.getPrice());
            }
        };
        Collections.sort(listToSort, comparator);

    }

    public void sortByName(List<StationeryItem> listToSort) {
        Comparator<StationeryItem> comparator = new Comparator<StationeryItem>() {
            public int compare(StationeryItem obj1, StationeryItem obj2) {
                return obj1.getNameOfItem().compareTo(obj2.getNameOfItem());
            }
        };
        Collections.sort(listToSort, comparator);
    }


    public void sortByCostAndName(List<StationeryItem> listToSort) {
        Comparator<StationeryItem> comparator = new Comparator<StationeryItem>() {
            public int compare(StationeryItem obj1, StationeryItem obj2) {
                if(Long.compare(obj1.getPrice(),obj2.getPrice())==0){
                    return obj1.getNameOfItem().compareTo(obj2.getNameOfItem());
                }
                else {
                    return Long.compare(obj1.getPrice(), obj2.getPrice());
                }
            }
        };
        Collections.sort(listToSort, comparator);
    }

}
