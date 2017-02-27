package epam.java.se;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 27.02.2017.
 */
public class StationeryRecords {
    private ArrayList<Employee> employees;

    public StationeryRecords(){
        employees = new ArrayList<Employee>();
    }
    public void addEmployee(Employee ... employee){
        for(Employee e : employee){
            employees.add(e);
        }
    }

    public long getStationeryCost(Employee employee) {
        long result=0;
        for(Stationery item : employee.getStationeryList()){
            result+= item.getPrice();
        }
        return result;
    }
}
