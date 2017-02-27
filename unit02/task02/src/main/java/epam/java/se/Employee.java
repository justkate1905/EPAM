package epam.java.se;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 27.02.2017.
 */
public class Employee {
    private String employeeName;
    private ArrayList<Stationery> stationeryList;

    public Employee(){
        employeeName = "NoName";
        stationeryList = new ArrayList<Stationery>();
    }

    public Employee(String name){
        employeeName = name;
        stationeryList = new ArrayList<Stationery>();
    }

    public void addItem(Stationery ... stationery){
        for(Stationery s : stationery){
            stationeryList.add(s);
        }
    }


    public void setName(String name){
        employeeName = name;
    }
    public ArrayList<Stationery> getStationeryList(){
        return stationeryList;
    }
}
